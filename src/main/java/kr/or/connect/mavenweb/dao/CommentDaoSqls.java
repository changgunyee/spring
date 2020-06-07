package kr.or.connect.mavenweb.dao;

public class CommentDaoSqls {
    public static final String SELECT_COMMENT_BY_DISPLAY_INFO_ID = " select rc.id as comment_id, rc.product_id, rc.score, rc.comment, rc.create_date, rc.modify_date, rc.reservation_info_id, ri.reservation_name, ri.reservation_tel, ri.reservation_email, ri.reservation_date "+
            " from reservation_info as ri inner join reservation_user_comment as rc on ri.id=rc.reservation_info_id "+
            " where ri.display_info_id=:displayInfoId; ";
    public static final String SELECT_COMMENT_IMAGE_BY_COMMENT_ID = " select ri.id as image_id, ri.reservation_info_id, ri.reservation_user_comment_id, ri.file_id, f.file_name, f.save_file_name, f.content_type, f.delete_flag, f.create_date, f.modify_date "+
            " from reservation_user_comment as rc inner join reservation_user_comment_image as ri on rc.id=ri.reservation_user_comment_id inner join file_info as f on ri.file_id=f.id "+
            " where rc.id=:reservationUserCommentId; ";
    public static final String SELECT_FILE_INFO_BY_COMMENT_IMAGE_ID = " select * from file_info where id = ( select file_id from reservation_user_comment_image where id = :reservationCommentImageId ) ; ";
}
