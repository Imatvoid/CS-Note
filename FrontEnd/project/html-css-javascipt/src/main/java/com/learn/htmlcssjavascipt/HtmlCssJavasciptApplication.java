package com.learn.htmlcssjavascipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication()
public class HtmlCssJavasciptApplication {

    public static void main(String[] args) {
        SpringApplication.run(HtmlCssJavasciptApplication.class, args);
    }

}
