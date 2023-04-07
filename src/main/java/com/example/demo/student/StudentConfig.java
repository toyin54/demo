package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo repo){
        return args-> {
            Student ayyub =
                    new Student("Ayyub",
                            LocalDate.of(1995,12,24),
                            "ayyubjose@aol.com");

            Student ramat =
                    new Student(
                            "Ramat",
                            LocalDate.of(1999,12,2),
                            "r@aol.com");

            repo.saveAll(
                    List.of(ayyub,ramat));
        };
    };
}
