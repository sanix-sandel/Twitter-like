package com.sanix.Twitter.api;

import com.sanix.Twitter.models.User;
import com.sanix.Twitter.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/")
    public List<User> getAllUsers(){
        return userService.getAll();
    }
}
