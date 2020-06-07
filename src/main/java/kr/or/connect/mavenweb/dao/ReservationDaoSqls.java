package kr.or.connect.mavenweb.dao;

public class ReservationDaoSqls {
    public static final String SELECT_RESERVATION_INFOS_BY_EMAIL = "select "+
            " reservation_info_id, display_info_id, ri.product_id, reservation_name, reservation_tel as reservation_telephone, reservation_email, reservation_date, "+
            " cancel_flag as cancel_yn, ri.create_date, ri.modify_date, sum(count*price) as total_price "+
            " from ( product_price as p inner join reservation_info_price as rp on p.id=rp.product_price_id ) inner join reservation_info as ri on ri.id=rp.reservation_info_id "+
            " where reservation_email=:reservationEmail group by ri.id";
    public static final String SELECT_RESERVATION_INFO_BY_ID = "select "+
            " id as reservation_info_id, display_info_id, product_id, reservation_name, reservation_tel as reservation_telephone, reservation_email, reservation_date, "+
            " cancel_flag as cancel_yn, create_date, modify_date"+
            " from reservation_info "+
            " where id=:reservationInfoId ";
    public static final String INSERT_RESERVATION_INFO = "insert into reservation_info "+
            " ( product_id, display_info_id, reservation_name, reservation_tel, reservation_email, reservation_date, cancel_flag, create_date, modify_date ) "+
            " values ( :productId, :displayInfoId, :reservationName, :reservationTel, :reservationEmail, :reservationDate, :cancelFlag, :createDate, :modifyDate); ";
    public static final String SELECT_RESERVATION_INFO_PRICE = "select "+
            " * "+
            " from reservation_info_price "+
            " where reservation_info_id=:reservationInfoId ";
    public static final String DELETE_RESERVATION_USER_COMMENT = "delete from reservation_user_comment where reservation_info_id=:reservationInfoId; ";
    public static final String DELETE_RESERVATION_INFO = "delete from reservation_info where id=:reservationInfoId; ";
    public static final String DELETE_RESERVATION_INFO_PRICE = "delete from reservation_info_price where reservation_info_id=:reservationInfoId; ";
    public static final String UPDATE_RESERVATION_INFO_CANCEL = "update reservation_info set cancel_flag=1 where id=:reservationInfoId;";
}
