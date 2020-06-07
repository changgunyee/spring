package kr.or.connect.mavenweb.controller.api;

import kr.or.connect.mavenweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryApiController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Map<String, Object> getCategoryResponse() {
        Map<String, Object> map = new HashMap<>();
        map.put("items", categoryService.getCategoryResponse());
        return map;
    }
}
