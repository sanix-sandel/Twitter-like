package com.sanix.Twitter.api;

import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.services.AuthService;
import com.sanix.Twitter.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class UserController {


    private final AuthService authService;
    private final UserService userService;


    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService=userService;

    }

    @RequestMapping("/signup")
    public ResponseEntity<String> create_user(@RequestBody UserRegistration userRegistration){
        authService.signup(userRegistration);
        return new ResponseEntity<>("User registered", OK);
    }

    @GetMapping("/api/")
    public List<User> getAllUsers(){
        return userService.getAll();
    }


}
