package com.cheng.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author create by chengnian On 2021/9/20 13:53
 */
@SpringBootApplication
@RestController
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping
    public String get() {
        return "gateway, port=" + port;
    }
}
