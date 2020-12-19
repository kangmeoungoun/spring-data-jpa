package me.goldapple.demospringdata.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    PostRepository postRepository;
    
    @Autowired
    CommentRepository comment;

    @Test
    public void getComment(){
        comment.getById(1L);

        System.out.println("===========================");

        Optional<Comment> byId = comment.findById(1L);
    }
}