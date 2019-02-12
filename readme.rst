

spring-cloud-multi-module-maven
~~~~~~~~~~~~

This project is a multi module maven project.

Modules are:
    ->config-server
        remote config is possible using git repository and call refresh func from actuator

    ->eureka-server
        discovery server

    ->gateway

    ->micro-service-1
        simple boot app that has one endpoint that fetch message from config server in response

    ->micro-service2
        simple boot app that has one endpoint that fetch message from config server in response