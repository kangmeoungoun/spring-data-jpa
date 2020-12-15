package me.goldapple.demospringdata;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by jojoldu@gmail.com on 2020-12-15
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@NoRepositoryBean
public interface MyRepository<T,ID extends Serializable> extends JpaRepository<T,ID> {
    boolean contains(T entity);
}
