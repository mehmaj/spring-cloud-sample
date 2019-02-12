package com.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    RouteLocator myRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("micro-service-1", p -> p.path("/v1/micro1/*")
                        .filters(
                                f -> f.stripPrefix(2)
                        )
                        .uri("lb://micro-service-1"))
                .route("micro-service-2", p -> p.path("/v1/micro2")
                        .filters(
                                f -> f.stripPrefix(2)
                        )
                        .uri("lb://micro-service-2")).build();
    }
}

