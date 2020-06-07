package kr.or.connect.mavenweb.dao;

import kr.or.connect.mavenweb.dto.FileInfo;
import kr.or.connect.mavenweb.dto.comment.Comment;
import kr.or.connect.mavenweb.dto.comment.CommentImage;
import kr.or.connect.mavenweb.dto.comment.CommentImageParam;
import kr.or.connect.mavenweb.dto.comment.CommentParam;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static kr.or.connect.mavenweb.dao.CommentDaoSqls.*;

@Repository
public class CommentDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert reservationCommentInsertAction;
    private SimpleJdbcInsert fileInfoInsertAction;
    private SimpleJdbcInsert reservationCommentImageInsertAction;
    private RowMapper<Comment> commentRowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
    private RowMapper<CommentImage> commentImageRowMapper = BeanPropertyRowMapper.newInstance(CommentImage.class);
    private RowMapper<FileInfo> fileInfoRowMapper = BeanPropertyRowMapper.newInstance(FileInfo.class);

    public CommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.reservationCommentInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_user_comment")
                .usingGeneratedKeyColumns("id");
        this.reservationCommentImageInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_user_comment_image")
                .usingGeneratedKeyColumns("id");
        this.fileInfoInsertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("file_info")
                .usingGeneratedKeyColumns("id");
    }

    public List<Comment> selectComments(Integer displayInfoId) {
        Map<String, Integer> params = Collections.singletonMap("displayInfoId", displayInfoId);
        return jdbc.query(SELECT_COMMENT_BY_DISPLAY_INFO_ID, params, commentRowMapper);
    }

    public List<CommentImage> selectCommentImages(Integer reservationUserCommentId) {
        Map<String, Integer> params = Collections.singletonMap("reservationUserCommentId", reservationUserCommentId);
        return jdbc.query(SELECT_COMMENT_IMAGE_BY_COMMENT_ID, params, commentImageRowMapper);
    }

    public Integer insertFileInfo(FileInfo fileInfo) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(fileInfo);
        return fileInfoInsertAction.executeAndReturnKey(params).intValue();
    }

    public Integer insertReservationCommentImage(CommentImageParam commentImageParam) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(commentImageParam);
        return reservationCommentImageInsertAction.executeAndReturnKey(params).intValue();
    }

    public Integer insertReservationComment(CommentParam commentParam) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(commentParam);
        return reservationCommentInsertAction.executeAndReturnKey(params).intValue();
    }

    public FileInfo selectCommentImageFileInfo(int reservationCommentImageId) {
        return jdbc.queryForObject(SELECT_FILE_INFO_BY_COMMENT_IMAGE_ID, Collections.singletonMap("reservationCommentImageId", reservationCommentImageId), fileInfoRowMapper);
    }
}
