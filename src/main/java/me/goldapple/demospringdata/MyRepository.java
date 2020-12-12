package me.goldapple.demospringdata;

/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyRepository<T,Id extends Serializable> extends Repository<T,Id> {
    <E extends T> E save(E entity);
    List<T> findAll();
    long count();
}
