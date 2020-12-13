package me.goldapple.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public interface CommentRepository extends MyRepository<Comment,Long>{
    List<Comment> findByCommentContains(String keyword);
    Page<Comment> findByLikeCountGreaterThanAndPost(int likecount, Post post, Pageable pageable);
}