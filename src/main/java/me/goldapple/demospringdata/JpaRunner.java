package me.goldapple.demospringdata;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private Kmo kmo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("========================");
        System.out.println(kmo.getName());
        postRepository.findAll().forEach(System.out::println);

        Post post = new Post();
        post.setTitle("spring");

        Comment comment = new Comment();
        comment.setComment("hello");
        postRepository.save(post);



    }
}