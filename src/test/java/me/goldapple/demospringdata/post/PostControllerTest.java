package me.goldapple.demospringdata.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

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
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PostRepository postRepository;
    @Test
    public void getPost()throws Exception{
        createPosts();
        this.mockMvc.perform(get("/post/1"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(content().string("jpa"));
    }
    @Test
    public void getPosts() throws Exception {
        createPosts();

        this.mockMvc.perform(get("/posts/")
                    .param("page","3")
                    .param("size","10")
                    .param("sort","created,desc")
                    .param("sort","title"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.content[0].title",is("jpa")))
                    ;
    }

    private void createPosts() {
        for (int i = 0; i < 100; i++) {
            Post post = new Post();
            post.setTitle("jpa"+i);
            postRepository.save(post);
        }

    }
}