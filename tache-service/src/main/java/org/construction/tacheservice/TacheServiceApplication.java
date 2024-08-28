package org.construction.tacheservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TacheServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacheServiceApplication.class, args);
    }

}
