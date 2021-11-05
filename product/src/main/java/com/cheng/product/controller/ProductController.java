package com.cheng.product.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author create by chengnian On 2021/9/19 21:59
 */
@Controller
@RequestMapping("product")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${server.port}")
    private String port;

    @RequestMapping("getProductName")
    @ResponseBody
    public String getProductName(String id) throws Exception {
        logger.info("called method getProductName(String id), port={}, id={}", port, id);
        Map<String,String> productNameMap = new HashMap<>();

        productNameMap.put("1", "T恤");
        productNameMap.put("2", "短裙");
        productNameMap.put("3", "超短裙");
        productNameMap.put("4", "短裤");

        List<String> list = new ArrayList<>();
        productNameMap.forEach((key, value) -> {
            list.add(key);
        });

        if(!list.contains(id)){
            throw new Exception("调用失败");
        }

        Thread.sleep(3000);

        return productNameMap.get(id);

    }
}
