package kr.or.connect.mavenweb.dao;

import kr.or.connect.mavenweb.dto.Category;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

import static kr.or.connect.mavenweb.dao.CategoryDaoSqls.SELECT_CATEGORY;

@Repository
public class CategoryDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
    private SimpleJdbcInsert insertAction;

    public CategoryDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("category")
                .usingGeneratedKeyColumns("id");
    }

    public List<Category> select() {
        return jdbc.query(SELECT_CATEGORY, rowMapper);
    }
}
