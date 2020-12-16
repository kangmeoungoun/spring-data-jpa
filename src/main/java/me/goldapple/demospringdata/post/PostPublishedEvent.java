package me.goldapple.demospringdata.post;

import org.springframework.context.ApplicationEvent;

/**
 * Created by jojoldu@gmail.com on 2020-12-16
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class PostPublishedEvent extends ApplicationEvent {
    private final Post post;

    public PostPublishedEvent(Object source) {
        super(source);
        this.post= (Post)source;
    }

    public Post getPost() {
        return post;
    }
}
