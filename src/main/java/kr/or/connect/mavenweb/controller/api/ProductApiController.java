package kr.or.connect.mavenweb.controller.api;

import kr.or.connect.mavenweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/products")
public class ProductApiController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Map<String, Object> getProducts(@RequestParam(name = "categoryId", required = false, defaultValue = "0") Integer categoryId,
                                           @RequestParam(name = "start", required = false, defaultValue = "0") Integer start) {
        Map<String, Object> map = new HashMap<>();
        map.put("items", productService.getProductResponse(categoryId, start));
        map.put("totalCount", productService.getProductCountResponse(categoryId));
        return map;
    }

    @GetMapping("/{displayInfoId}")
    public Map<String, Object> getDisplayInfo(@PathVariable(name = "displayInfoId") int displayInfoId) {
        Map<String, Object> displayInfo = productService.getDisplayInfoResponse(displayInfoId);
        return displayInfo;
    }
}
