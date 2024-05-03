package com.ashwetaw.springbootgenericcrud.repositories;

import com.ashwetaw.springbootgenericcrud.entities.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author koheincs
 * @created at 02/05/2024
 **/
@EnableScan
public interface IUserRepository extends CrudRepository<User,String> {
    Optional<User> findByUsername(String username);
}
