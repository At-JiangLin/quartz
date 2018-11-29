package com.example.springbootquartz.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: ljl
 * @Date: 2018/11/29 17:40
 * @Description:
 */

@FeignClient(value = "consul-demo1")
public interface TestService {

    @GetMapping("/test")
    String index();
}
