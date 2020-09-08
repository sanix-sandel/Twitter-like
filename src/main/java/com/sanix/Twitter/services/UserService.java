package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {


    private final UserRepository userRepository; //Dependency Injection

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(UserRegistration userRegistration){
        User user=new User();
        user.setUsername(userRegistration.getUsername());
        user.setEmail(userRegistration.getEmail());
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll()
                .stream()
                .collect(toList());
    }

    public User findByUsername(String username){
        Optional <User> userOptional=userRepository.findByUsername(username);

        if(!userOptional.isPresent()){
            throw new RuntimeException("User not found");
        }
        return userOptional.get();
    }

    public User findById(Long id){
        Optional <User> userOptional=userRepository.findById(id);

        if(!userOptional.isPresent()){
            throw new RuntimeException("User not found");
        }
        return userOptional.get();
    }


}
