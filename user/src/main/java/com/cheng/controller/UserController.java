package com.cheng.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cheng.feignClient.ProductFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author create by chengnian On 2021/9/19 15:04
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private ProductFeign productFeign;

    @RequestMapping("getProduct")
    @ResponseBody
    @SentinelResource("getProduct")
    public String getProduct(String id){
        return productFeign.getProductName(id);
    }
}
