package com.codeup.repositories;

import com.codeup.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by frenchfryes on 6/22/17.
 */
public interface UserRepository extends CrudRepository<User, Long>{
}
