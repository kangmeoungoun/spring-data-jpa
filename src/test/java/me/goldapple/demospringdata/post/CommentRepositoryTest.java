package me.goldapple.demospringdata.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRepositoryTest {

    @Autowired
    PostRepository posts;

    @Autowired
    CommentRepository comments;

    @Test
    public void getComment() {
        Post post = new Post( );
        post.setTitle("jpa");
        Post savedPost = posts.save(post);


        Comment comment = new Comment( );
        comment.setComment("goldapple");
        comment.setPost(savedPost);
        comment.setUp(10);
        comment.setDown(1);
        comments.save(comment);

        List<CommentOnly> byPost_id = comments.findByPost_Id(savedPost.getId( ) , CommentOnly.class);
        byPost_id.forEach(c -> {
            System.out.println("=============");
            System.out.println(c.getComment( ));
        });
    }

    @Test
    public void specs(){
        Page<Comment> all = comments.findAll(CommentSpecs.isBest().and(CommentSpecs.isGood()) , PageRequest.of(0 , 10));
    }
    @Test
    public void qbe(){
        Comment prove = new Comment();
        prove.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("up","down");
        Example<Comment> example = Example.of(prove , exampleMatcher);
        List<Comment> all = comments.findAll(example);
    }
}