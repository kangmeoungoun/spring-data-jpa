package me.goldapple.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

public interface PostRepository extends JpaRepository<Post,Long> {
    Page<Post> findByTitleContains(String title, Pageable pageable);
    long countByTitleContains(String title);
}
