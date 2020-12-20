package me.goldapple.demospringdata.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    private EntityManager entityManager;


    @Test
    public void save() throws Exception {
        Post post = new Post();
        post.setTitle("jpa");
        Post savePost = postRepository.save(post);//insert persist
        savePost.setTitle("goldapple");
        List<Post> all = postRepository.findAll();
        assertEquals(1, all.size());
    }

    @Test
    public void findByTitleStartsWith() {
        savePost();
        List<Post> spring = postRepository.findByTitleStartsWith("Spring");
        assertEquals(1, spring.size());
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring");
        return postRepository.save(post);//insert persist
    }
    @Test
    public void findByTitle() {
        savePost();
//        List<Post> spring = postRepository.findByTitle("Spring", Sort.by("title").ascending());
        List<Post> spring = postRepository.findByTitle("Spring", JpaSort.unsafe("LENGTH(title)"));
        assertEquals(1, spring.size());
    }

    @Test
    public void updateTitle() {
        Post post = new Post();
        post.setTitle("Spring");
        Post spring = postRepository.save(post);//insert persist
        //권장하지 않는 방법
        /*
        String hibernate = "hibernate";
        int update = postRepository.updateTitle(hibernate, spring.getId());
        assertThat(update).isEqualTo(1);
        Optional<Post> byId = postRepository.findById(spring.getId());
        assertThat(byId.get().getTitle()).isEqualTo(hibernate);
        */

        //권장하는 방법
        List<Post> all = postRepository.findAll();
        post.setTitle("hibernate");
        //assertThat(all.get(0).getTitle()).isEqualTo("hibernate");
    }



}