package me.goldapple.demospringdata.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByTitleStartsWith(String title);

    @Query("SELECT p FROM #{#entityName}  AS p WHERE p.title = :title")
    List<Post> findByTitle(@Param("title")String keyword, Sort sort);


    @Transactional
    @Modifying
    @Query(value = "UPDATE Post p Set p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String hibernate, Long id);
}
