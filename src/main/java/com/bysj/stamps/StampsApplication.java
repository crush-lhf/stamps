package com.bysj.stamps;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author crush
 * 启动类
 */
@SpringBootApplication
@Controller
@MapperScan(basePackages = "com.bysj.stamps.*.dao")
public class StampsApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StampsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StampsApplication.class);
    }

    @RequestMapping("/")
    public String index() {
        return "login";
    }
}
