package me.goldapple.demospringdata.post;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-12-15
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public interface PostCustomRepository<T> {
    List<Post> findMyPost();
    void delete(T entity);
}
