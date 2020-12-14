package me.goldapple.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;

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
    public void crud() throws ExecutionException, InterruptedException {
        this.createComment(100,"spring data jpa");
        this.createComment(50,"HIBERNATE SPRING");
        commentRepository.flush();
        List<Comment> all = commentRepository.findAll();
        assertThat(all.size()).isEqualTo(2);

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by("likeCount").descending());

        ListenableFuture<List<Comment>> future =
                commentRepository.findByCommentContainsIgnoreCase("Spring", pageRequest);
        System.out.println("============");
        System.out.println("is done?"+future.isDone());
        future.addCallback(new ListenableFutureCallback<List<Comment>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }
            @Override
            public void onSuccess(@Nullable List<Comment> comments) {
                System.out.println("===================");
                comments.forEach(System.out::println);
            }
        });
        Thread.sleep(5000l);
    }

    private void createComment(int likeCount,String comment) {
        Comment newComment = new Comment();
        newComment.setComment(comment);
        newComment.setLikeCount(likeCount);
        commentRepository.save(newComment);
    }

}