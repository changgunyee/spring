package kr.or.connect.mavenweb.dao;

import kr.or.connect.mavenweb.dto.Promotion;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.or.connect.mavenweb.dao.PromotionDaoSqls.SELECT_PROMOTION;


@Repository
public class PromotionDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
    private SimpleJdbcInsert insertAction;

    public PromotionDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("promotion")
                .usingGeneratedKeyColumns("id");
    }

    public List<Promotion> select() {
        return jdbc.query(SELECT_PROMOTION, rowMapper);
    }
}
