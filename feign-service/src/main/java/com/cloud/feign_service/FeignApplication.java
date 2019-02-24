package com.cloud.feign_service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@RefreshScope
@EnableHystrix
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }
}

@RestController
class FeignRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "rootFallBack", commandKey = "root", groupKey = "root")
    public ResponseEntity home(@RequestParam("message") String message) {
        if (RandomUtils.nextBoolean())
            throw new RuntimeException("");
        return new ResponseEntity<>("response from feign-service => ".concat(message), HttpStatus.OK);
    }

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

    public ResponseEntity rootFallBack(String message) {
        return new ResponseEntity<>("fall back method => " + message, HttpStatus.OK);
    }

}
