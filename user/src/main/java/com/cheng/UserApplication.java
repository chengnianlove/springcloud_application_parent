package com.cheng;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author create by chengnian On 2021/9/19 15:00
 */
@SpringBootApplication
@RestController
@RefreshScope
@EnableDiscoveryClient
@EnableFeignClients
public class UserApplication {

    @Value("${server.port}")
    private String port;

    @Value("${user.name}")
    private String name;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @RequestMapping
    public String get(){
        return "user, port=" + port + "name=" + name;
    }

    @Bean
    public IRule getRule(){
        return new RandomRule();
    }
}
