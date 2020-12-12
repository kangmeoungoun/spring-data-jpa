package me.goldapple.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Component
@Transactional
public class JpaRunner implements ApplicationRunner {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        Post post = new Post();
//        post.setTitle("Spring Data JPA 언제 보나...");
//        Comment comment = new Comment();
//        comment.setComment("빨리 보고 싶어요");
//        Comment comment1 = new Comment();
//        comment1.setComment("곧 보여드릴게요");
//        post.addComment(comment);
//        post.addComment(comment1);

        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 4L);
        System.out.println("======================");
        System.out.println(post.getTitle());

        post.getComments().forEach(c->{
            System.out.println("=============");
            System.out.println(c.getComment());
            ;
        });
    }
}
