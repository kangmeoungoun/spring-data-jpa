package me.goldapple.demospringdata.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by jojoldu@gmail.com on 2020-12-18
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post/{id}")
    public String getPost(@PathVariable("id") Post post){
        return post.getTitle();
    }
    @GetMapping("/posts/")
    public Page<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }
}
