package com.cloud.micro_service_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@RefreshScope
public class EurekaClientApplication {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}

@RestController
class ServiceInstanceRestController {

    @Value("${config.message}")
    String message;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    MicroServiceClient microServiceClient;

    @RequestMapping("/")
    @ResponseBody
    public ResponseEntity home() {
        return new ResponseEntity<>(microServiceClient.home(message), HttpStatus.OK);
    }

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }

}

