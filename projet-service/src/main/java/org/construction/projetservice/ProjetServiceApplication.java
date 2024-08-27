package org.construction.projetservice;

import org.construction.projetservice.model.Projet;
import org.construction.projetservice.repository.ProjetRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ProjetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetServiceApplication.class, args);

    }
@Bean
    CommandLineRunner commandLineRunner(ProjetRepository projetRepository){
        return args -> {
            List<Projet> projetList=List.of(
                    Projet.builder()
                            .name("Construction ecole privee")
                            .dateCreation(LocalDate.now())
                            .description("lllllllllllllll")
                            .build(),
                    Projet.builder()
                            .name("Construction ecole primaire")
                            .dateCreation(LocalDate.now())
                            .description("llllllmmmmmmmmmlllll")
                            .build()

            );
            projetRepository.saveAll(projetList);
        };
}
}