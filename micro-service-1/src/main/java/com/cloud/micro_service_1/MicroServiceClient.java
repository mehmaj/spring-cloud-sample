package com.cloud.micro_service_1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "feign-service")
@Component
public interface MicroServiceClient {
    @RequestMapping("/")
    String home(@RequestParam(value = "message") String message);
}
