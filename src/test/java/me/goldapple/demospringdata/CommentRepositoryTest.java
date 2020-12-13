package me.goldapple.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {
    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void crud(){

        List<Comment> comments = commentRepository.findAll();
       /*
        assertThat(comments).isEmpty();
        Optional<Comment> byId = commentRepository.findById(100l);
        assertThat(byId).isEmpty();
        Comment comment = byId.orElseThrow(IllegalArgumentException::new);
        */
        commentRepository.save(null);
    }

}