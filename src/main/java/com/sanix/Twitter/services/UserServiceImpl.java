package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.UserActionDto;
import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService{


    private final UserRepository userRepository; //Dependency Injection

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserRegistration userRegistration){
        User user=new User();
        user.setUsername(userRegistration.getUsername());
        user.setEmail(userRegistration.getEmail());
        userRepository.save(user);
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll()
                .stream()
                .collect(toList());
    }

    @Override
    public User findByUsername(String username){
        Optional <User> userOptional=userRepository.findByUsername(username);

        if(!userOptional.isPresent()){
            throw new RuntimeException("User not found");
        }
        return userOptional.get();
    }

    @Override
    public User findById(Long id){
        Optional <User> userOptional=userRepository.findById(id);

        if(!userOptional.isPresent()){
            throw new RuntimeException("User not found");
        }
        return userOptional.get();
    }

    @Override
    public List<User> usersToFollow(User user){
        ArrayList<User> liste=new ArrayList<>();
        liste.addAll(userRepository.findAll()
                .stream()
                .filter(x->x!=user).collect(toList()));
        return liste;
    }



}
