package me.goldapple.demospringdata.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by jojoldu@gmail.com on 2020-12-18
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByTitleStartsWith(String title);

    @Query("SELECT p FROM Post AS p WHERE p.title = ?1")
    List<Post> findByTitle(String title);

}
