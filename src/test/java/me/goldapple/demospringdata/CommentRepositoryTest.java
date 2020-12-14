package me.goldapple.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

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
        createComment(100,"spring data jpa");
        createComment(50,"HIBERNATE SPRING");

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("likeCount").descending());
        /*
        페이징 처리로 받기
        Page<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        assertThat(comments.getNumberOfElements()).isEqualTo(2);
        assertThat(comments).first().hasFieldOrPropertyWithValue("likeCount",100);
         */
        /*Stream 닫아줘야 하기 때문에 try with 문 으로 받기*/
        try(Stream<Comment> comments = commentRepository.findByCommentContainsIgnoreCase("Spring",pageRequest)){
            Comment firstComment = comments.findFirst().get();
            assertThat(firstComment.getLikeCount()).isEqualTo(100);

        }
    }

    private void createComment(int likeCount,String comment) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(likeCount);
        commentRepository.save(newComment);
    }

}