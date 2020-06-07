package kr.or.connect.mavenweb.dao;

import kr.or.connect.mavenweb.dto.product.*;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static kr.or.connect.mavenweb.dao.ProductDaoSqls.*;

@Repository
public class ProductDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<Product> productRowMapper = BeanPropertyRowMapper.newInstance(Product.class);
    private RowMapper<DisplayInfo> displayInfoRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
    private RowMapper<DisplayInfoImage> displayInfoImageRowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImage.class);
    private RowMapper<ProductImage> productImageRowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
    private RowMapper<ProductPrice> productPriceRowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

    public ProductDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Product> selectProducts(Integer categoryId, Integer start, Integer limit) {
        Map<String, Integer> params = new HashMap<>();
        params.put("start", start);
        params.put("limit", limit);
        String query = SELECT_PRODUCT_ALL;
        if (categoryId != 0) {
            params.put("categoryId", categoryId);
            query = SELECT_PRODUCT_BY_CATEGORY_ID;
        }
        return jdbc.query(query, params, productRowMapper);
    }

    public DisplayInfo selectDisplayInfo(Integer displayInfoId) {
        Map<String, Integer> params = Collections.singletonMap("displayInfoId", displayInfoId);
        return jdbc.queryForObject(SELECT_DISPLAY_INFO_BY_DISPLAY_INFO_ID, params, displayInfoRowMapper);
    }

    public DisplayInfoImage selectDisplayInfoImage(Integer displayInfoId) {
        Map<String, Integer> params = Collections.singletonMap("displayInfoId", displayInfoId);
        return jdbc.queryForObject(SELECT_DISPLAY_INFO_IMAGE_BY_DISPLAY_INFO_ID, params, displayInfoImageRowMapper);
    }


    public List<ProductImage> selectProductImages(Integer productId) {
        Map<String, Integer> params = Collections.singletonMap("productId", productId);
        return jdbc.query(SELECT_PRODUCT_IMAGE_BY_DISPLAY_INFO_ID, params, productImageRowMapper);
    }

    public List<ProductPrice> selectProductPrices(Integer productId) {
        Map<String, Integer> params = Collections.singletonMap("productId", productId);
        return jdbc.query(SELECT_PRODUCT_PRICE_BY_DISPLAY_INFO_ID, params, productPriceRowMapper);
    }

    public int countProduct(Integer categoryId) {
        Map<String, Integer> params = new HashMap<>();
        String query = COUNT_PRODUCT_ALL;
        if (categoryId != 0) {
            params.put("categoryId", categoryId);
            query = COUNT_PRODUCT_BY_CATEGORY_ID;
        }
        return jdbc.queryForObject(query, params, Integer.class);
    }
}
