package kr.or.connect.mavenweb.controller.api;

import kr.or.connect.mavenweb.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/promotions")
public class PromotionApiController {
    @Autowired
    private PromotionService promotionService;

    @GetMapping
    public Map<String, Object> getPromotionResponse() {
        Map<String, Object> map = new HashMap<>();
        map.put("items", promotionService.getPromotionResponse());
        return map;
    }
}
