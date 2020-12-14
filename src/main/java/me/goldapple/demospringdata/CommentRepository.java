package me.goldapple.demospringdata;

import org.springframework.data.domain.Pageable;

import java.util.stream.Stream;

/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public interface CommentRepository extends MyRepository<Comment,Long>{
    //Page<Comment> findByCommentContainsIgnoreCase(String keyworkd, Pageable pageable);
    Stream<Comment> findByCommentContainsIgnoreCase(String keyworkd, Pageable pageable);

}