package me.goldapple.demospringdata.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jojoldu@gmail.com on 2020-12-16
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Configuration
public class PostRepositoryTestConfig {
    @Bean
    public ApplicationListener<PostPublishedEvent> postListener(){
        return event -> {
            System.out.println("===========================================");
            System.out.println(event.getPost().getTitle()+"is published");
            System.out.println("===========================================");
        };
    }
}