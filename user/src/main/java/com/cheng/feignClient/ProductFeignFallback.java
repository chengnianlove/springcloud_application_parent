package com.cheng.feignClient;

import org.springframework.stereotype.Component;

/**
 * @author create by chengnian On 2021/9/24 22:20
 */
@Component
public class ProductFeignFallback implements ProductFeign{
    @Override
    public String getProductName(String id) {
        return "未查到对应的商品信息";
    }
}
