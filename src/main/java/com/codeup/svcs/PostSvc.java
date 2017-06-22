package com.codeup.svcs;

import com.codeup.models.Post;
import com.codeup.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frenchfryes on 6/20/17.
 */
@Service("postSvc")
public class PostSvc {
    private final PostRepository postdao;

//Autowire an instance
    //1. Add a private property of type X
    //2. Create/update the constructor of the class Y where you
    // added the property
    //3. add the @autowire annotation to the constructor if needed
@Autowired
    public PostSvc(PostRepository postdao){
    this.postdao = postdao;
    }

    public Iterable<Post> findAll(){
        return postdao.findAll();
    }

    public Post findOne(long id){

        return postdao.findOne(id);
    }

    public Post save(Post post){

        return postdao.save(post);
    }

    private void createPosts(){
        save(new Post("ps4", "shiny and new"));
        save(new Post("xbox juan", "not so shiny and new"));
    }

    public void createPost(String title, String body){
        save(new Post(title, body));
    }

    public void deletePost(Long id){

        postdao.delete(id);
    }

}
