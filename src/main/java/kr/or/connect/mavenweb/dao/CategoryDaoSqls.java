package kr.or.connect.mavenweb.dao;

public class CategoryDaoSqls {
    public static final String SELECT_CATEGORY = "select c.id, c.name, count(*) from product as p inner join category as c on p.category_id=c.id group by c.id;";
}
