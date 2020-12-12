package me.goldapple.demospringdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Import(KmoRegistrar.class)
public class DemospringdataApplication {


    public static void main(String[] args) {

        SpringApplication.run(DemospringdataApplication.class, args);
    }

}
