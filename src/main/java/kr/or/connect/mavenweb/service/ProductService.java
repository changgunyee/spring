package kr.or.connect.mavenweb.service;

import kr.or.connect.mavenweb.dto.product.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProductService {

    default Integer getLimit() {
        return 4;
    }

    default Map<String, String> getPriceTypeNameMap() {
        Map<String, String> priceTypeNameMap = new HashMap<>();
        priceTypeNameMap.put("A", "성인");
        priceTypeNameMap.put("Y", "청소년");
        priceTypeNameMap.put("B", "유아");
        priceTypeNameMap.put("S", "셋트");
        priceTypeNameMap.put("D", "장애인");
        priceTypeNameMap.put("C", "지역주민");
        priceTypeNameMap.put("V", "VIP");
        priceTypeNameMap.put("R", "R석");
        priceTypeNameMap.put("B", "B석");
        priceTypeNameMap.put("S", "S석");
        priceTypeNameMap.put("D", "평일");
        return priceTypeNameMap;
    }

    public List<Product> getProductResponse(Integer categoryId, Integer start);

    public int getProductCountResponse(Integer categoryId);

    public Map<String, Object> getDetailDisplayInfo(Integer displayInfoId);

    public Map<String, Object> getDisplayInfoResponse(Integer displayInfoId);

}
