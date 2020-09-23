package com.sanix.Twitter.repositories;

import com.sanix.Twitter.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends CrudRepository<User, String> {

    public User findByEmailIgnoreCase(@Param("email") String email);
}
