package me.goldapple.demospringdata.post;


import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {
    public static Specification<Comment> isBest() {
       return (Specification<Comment>) (root,query,builder)->{
           return builder.isTrue(root.get(Comment_.best));
       };
    }
    public static Specification<Comment> isGood(){
        return (Specification<Comment>) (root,query,builder)->{
            return builder.greaterThan(root.get(Comment_.UP),10);
        };
    }
}
