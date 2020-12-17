package me.goldapple.demospringdata.post;

import me.goldapple.demospringdata.MyRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Created by jojoldu@gmail.com on 2020-12-15
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public interface PostRepository extends MyRepository<Post,Long>, QuerydslPredicateExecutor<Post> {

}
