package kr.or.connect.mavenweb.dao;

public class ProductDaoSqls {
    public static final String SELECT_PRODUCT_BY_CATEGORY_ID = " select d.id as display_info_id,p.id as product_id,description as product_description,place_name,content as product_content,save_file_name as product_image_url "+
            " from product as p inner join display_info as d on p.id=d.product_id inner join product_image as i on p.id=i.product_id inner join file_info as f on i.file_id=f.id "+
            " where type='th' and category_id=:categoryId limit :start, :limit; ";
    public static final String SELECT_PRODUCT_ALL = " select d.id as display_info_id,p.id as product_id,description as product_description,place_name,content as product_content,save_file_name as product_image_url "+
            " from product as p inner join display_info as d on p.id=d.product_id inner join product_image as i on p.id=i.product_id inner join file_info as f on i.file_id=f.id "+
            " where type='th' limit :start, :limit; ";
    public static final String COUNT_PRODUCT_BY_CATEGORY_ID = " select count(*) "+
            " from product as p inner join display_info as d on p.id=d.product_id "+
            " where category_id=:categoryId;";
    public static final String COUNT_PRODUCT_ALL = " select count(*) "+
            " from product as p inner join display_info as d on p.id=d.product_id ";
    public static final String SELECT_DISPLAY_INFO_BY_DISPLAY_INFO_ID = " select d.id as display_info_id, d.product_id, d.opening_hours, d.place_name, d.place_lot,d.place_street, d.tel as telephone, d.homepage, d.email, d.create_date, d.modify_date, p.content as product_content,p.description as product_description, p.event as product_event, c.id as categoryId, c.name as category_name "+
            " from display_info as d inner join product as p on d.product_id=p.id inner join category as c on p.category_id=c.id "+
            " where d.id=:displayInfoId; ";
    public static final String SELECT_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_ID = " select d.id as display_info_image_id, d.display_info_id, d.file_id, f.file_name, f.save_file_name, f.content_type, f.delete_flag, f.create_date, f.modify_date "+
            " from display_info_image as d inner join file_info as f on d.file_id=f.id where d.display_info_id=:displayInfoId; ";
    public static final String SELECT_PRODUCT_PRICE_BY_DISPLAY_INFO_ID = " select id as product_price_id, product_id, price_type_name, price, discount_rate, create_date, modify_date "+
            " from product_price "+
            " where product_id=:productId; ";
    public static final String SELECT_PRODUCT_IMAGE_BY_DISPLAY_INFO_ID = " select p.id as product_image_id, p.product_id, p.type, f.id as file_info_id, f.file_name, f.save_file_name, f.content_type, f.delete_flag, f.create_date, f.modify_date "+
            " from product_image as p inner join file_info as f on p.file_id=f.id "+
            " where product_id=:productId and (type='ma' or type='et'); ";
}

