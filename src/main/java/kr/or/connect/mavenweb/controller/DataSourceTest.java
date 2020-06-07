package kr.or.connect.mavenweb.controller;

import kr.or.connect.mavenweb.config.ApplicationConfig;
import kr.or.connect.mavenweb.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataSourceTest {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        ProductService productService = ac.getBean(ProductService.class);
        System.out.println(productService.getDetailDisplayInfo(2));

    }
}
