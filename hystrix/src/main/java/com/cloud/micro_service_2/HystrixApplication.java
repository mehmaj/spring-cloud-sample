package com.cloud.micro_service_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }
}

//@RestController
//@RefreshScope
//class ServiceInstanceRestController {
//
//    @Value("${config.message}")
//    String message;
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @RequestMapping("/")
//    @ResponseBody
//    public ResponseEntity<String> home() {
//        return new ResponseEntity<>(message, HttpStatus.OK);
//    }
//
//    @RequestMapping("/service-instances/{applicationName}")
//    public List<ServiceInstance> serviceInstancesByApplicationName(
//            @PathVariable String applicationName) {
//        return this.discoveryClient.getInstances(applicationName);
//    }
//}
