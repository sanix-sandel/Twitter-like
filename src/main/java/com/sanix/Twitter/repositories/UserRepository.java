package com.sanix.Twitter.repositories;

import com.sanix.Twitter.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends CrudRepository<User, Long> {
}
