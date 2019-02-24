

spring-cloud-multi-module-maven
~~~~~~~~~~~~

This project is a multi module maven project.

Modules are:
    ->config-server
        remote config is possible using git repository and call refresh func from actuator

    ->eureka-server
        discovery server

    ->gateway
        use spring api gateway to route requests to microservices

    ->Feign
        micro services talk to each other using feign

    ->Hystrix | Hystrix dashboard
        use hystrix to monitor fault tolerance of each endpoint

    ->micro-service-1
        simple boot app that has one endpoint that fetch message from config server in response

    ->micro-service2
        simple boot app that has one endpoint that fetch message from config server in response

    -use spotify docker maven plugin to automatically build docker images for each module


    -after all use docker composer to run all modules at once


    -next step:
         kubernetes serverless architecture
