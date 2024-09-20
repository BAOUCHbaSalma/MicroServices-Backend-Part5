package org.construction.projetservice;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.repository.ProjetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class ProjetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetServiceApplication.class, args);

    }

}