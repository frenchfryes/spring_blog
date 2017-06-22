package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by frenchfryes on 6/22/17.
 */
public interface PostRepository extends CrudRepository<Post, Long>{
    /*Post findByTitle(String title);
    List<Post> findByTitleIsLike(String title);*/

}