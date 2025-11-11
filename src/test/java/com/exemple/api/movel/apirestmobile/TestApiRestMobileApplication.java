package com.exemple.api.movel.apirestmobile;

import org.springframework.boot.SpringApplication;

public class TestApiRestMobileApplication {

    public static void main(String[] args) {
        SpringApplication.from(ApiRestMobileApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
