package me.goldapple.demospringdata;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Async
    ListenableFuture<List<Comment>> findByCommentContainsIgnoreCase(String keyworkd, Pageable pageable);

}