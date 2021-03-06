package com.cheng.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author create by chengnian On 2021/9/19 22:06
 */
@FeignClient("PRODUCT")
public interface ProductFeign {

    @RequestMapping("/product/getProductName")
    String getProductName(@RequestParam("id") String id);
}
