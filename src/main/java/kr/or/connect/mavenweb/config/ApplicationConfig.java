package kr.or.connect.mavenweb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "kr.or.connect.mavenweb.dao", "kr.or.connect.mavenweb.service" })
@Import({ DBConfig.class })
public class ApplicationConfig {

}