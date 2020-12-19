package me.goldapple.demospringdata.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by jojoldu@gmail.com on 2020-12-18
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void save()throws Exception{
        Post post = new Post();
        post.setTitle("jpa");
        Post savePost =postRepository.save(post);//insert persist
        savePost.setTitle("goldapple");
        List<Post> all = postRepository.findAll();
        assertEquals(1,all.size());
    }
    @Test
    public void findByTitleStartsWith(){
        savePost();
        List<Post> spring = postRepository.findByTitleStartsWith("Spring");
        assertEquals(1,spring.size());
    }
    @Test
    public void findByTitle(){
        savePost();
        List<Post> spring = postRepository.findByTitle("Spring");
        assertEquals(1,spring.size());
    }

    private void savePost() {
        Post post = new Post();
        post.setTitle("Spring");
        postRepository.save(post);//insert persist
    }
}