package me.goldapple.demospringdata;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jojoldu@gmail.com on 2020-12-12
 * Blog : http://jojoldu.tistory.com
 * Github : http://github.com/jojoldu
 */
@Entity
public class Post {
    @Id @GeneratedValue
    private Long id;
    private String title;
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();

    public void addComment(Comment comment){
        this.getComments().add(comment);
        comment.setPost(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
