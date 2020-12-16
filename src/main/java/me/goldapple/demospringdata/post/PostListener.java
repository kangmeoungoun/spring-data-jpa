package me.goldapple.demospringdata.post;

import org.springframework.context.ApplicationListener;

/**
 * Created by jojoldu@gmail.com on 2020-12-16
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
public class PostListener implements ApplicationListener<PostPublishedEvent> {
    @Override
    //@EventListener  인터페이스 구현체로 안하고 어노테이션으로도 가능.
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("===========================================");
        System.out.println(event.getPost().getTitle()+"is published");
        System.out.println("===========================================");
    }
}
