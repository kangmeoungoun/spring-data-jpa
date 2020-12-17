package me.goldapple.demospringdata;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by jojoldu@gmail.com on 2020-12-15
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class SimpleMyRepository<T,ID extends Serializable> extends QuerydslJpaRepository<T,ID> implements MyRepository<T,ID> {

    private EntityManager entityManager;

    public SimpleMyRepository(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }
}
