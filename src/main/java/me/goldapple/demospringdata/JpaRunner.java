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
        Account account = new Account();
        account.setUsername("kmo");
        account.setPassword("jpa");
        Session session = entityManager.unwrap(Session.class);
        session.save(account);
    }
}
