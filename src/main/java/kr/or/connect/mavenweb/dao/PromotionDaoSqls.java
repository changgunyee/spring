package kr.or.connect.mavenweb.dao;

public class PromotionDaoSqls {
    public static final String SELECT_PROMOTION = "select p.id,p.product_id,f.save_file_name as product_image_url"+
            " from (promotion as p inner join product_image as pi on p.product_id=pi.product_id) inner join file_info as f on pi.file_id=f.id where pi.type='th';";
}
