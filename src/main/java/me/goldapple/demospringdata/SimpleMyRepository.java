package me.goldapple.demospringdata;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

/**
 * Created by jojoldu@gmail.com on 2020-12-15
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class SimpleMyRepository<T,ID extends Serializable> extends SimpleJpaRepository<T,ID> implements MyRepository<T,ID> {

    private EntityManager entityManager;

    public SimpleMyRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }
}
