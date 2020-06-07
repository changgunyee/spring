package kr.or.connect.mavenweb.service.impl;

import kr.or.connect.mavenweb.dao.ProductDao;
import kr.or.connect.mavenweb.dto.product.*;
import kr.or.connect.mavenweb.service.CommentService;
import kr.or.connect.mavenweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CommentService commentService;

    @Override
    public List<Product> getProductResponse(Integer categoryId, Integer start) {
        Integer limit = getLimit();
        return productDao.selectProducts(categoryId, start, limit);
    }

    @Override
    public int getProductCountResponse(Integer categoryId) {
        return productDao.countProduct(categoryId);
    }

    @Override
    public Map<String, Object> getDetailDisplayInfo(Integer displayInfoId) {
        DisplayInfo displayInfo = productDao.selectDisplayInfo(displayInfoId);
        DisplayInfoImage displayInfoImage = productDao.selectDisplayInfoImage(displayInfoId);

        Integer productId = displayInfo.getProductId();
        List<ProductImage> productImages = new ArrayList<>();
        List<ProductPrice> productPrices = new ArrayList<>();
        if (productId != null) {
            productImages = productDao.selectProductImages(productId);
            productPrices = getProductPrices(productId);
        }

        Map<String, Object> detailDisplayInfo = new HashMap<>();
        detailDisplayInfo.put("displayInfo", displayInfo);
        detailDisplayInfo.put("productImages", productImages);
        detailDisplayInfo.put("displayInfoImage", displayInfoImage);
        detailDisplayInfo.put("productPrices", productPrices);
        return detailDisplayInfo;
    }

    @Override
    public Map<String, Object> getDisplayInfoResponse(Integer displayInfoId) {

        Map<String, Object> displayInfoResponse = getDetailDisplayInfo(displayInfoId);

        Map<String, Object> comments = commentService.getComments(displayInfoId);
        displayInfoResponse.putAll(comments);

        return displayInfoResponse;
    }

    private List<ProductPrice> getProductPrices(int productId) {
        List<ProductPrice> productPrices = productDao.selectProductPrices(productId);
        Map<String, String> priceTypeNameMap = getPriceTypeNameMap();
        for (ProductPrice p : productPrices) {
            if (priceTypeNameMap.containsKey(p.getPriceTypeName())) {
                p.setPriceTypeName(priceTypeNameMap.get(p.getPriceTypeName()));
            }
        }
        return productPrices;
    }
}
