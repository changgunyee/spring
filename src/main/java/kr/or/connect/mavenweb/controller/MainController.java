package kr.or.connect.mavenweb.controller;

import kr.or.connect.mavenweb.service.CategoryService;
import kr.or.connect.mavenweb.service.ProductService;
import kr.or.connect.mavenweb.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/main")
public class MainController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public String renderMainPage(ModelMap modelMap) {
        modelMap.put("count", productService.getProductCountResponse(0));
        modelMap.put("categories", categoryService.getCategoryResponse());
        modelMap.put("promotions", promotionService.getPromotionResponse());
        return "main";
    }
}
