package me.goldapple.demospringdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryImplementationPostfix = "Default") //구현체 뒤에 붙이는 접미어 Impl
public class DemospringdataApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemospringdataApplication.class, args);
    }

}
