package com.sanix.Twitter.api;

import com.sanix.Twitter.Dto.UserActionDto;
import com.sanix.Twitter.Dto.UserAuthentication;
import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;
//import com.sanix.Twitter.services.AuthService;
import com.sanix.Twitter.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/users")
public class UserController {


   // private final AuthService authService;
    private final UserService userService;


    public UserController( UserService userService) {
        //this.authService = authService;
        this.userService=userService;

    }

    @RequestMapping("/signup")
    public ResponseEntity<String> create_user(@RequestBody UserRegistration userRegistration){
        //authService.signup(userRegistration);
        return new ResponseEntity<>("User registered", OK);
    }



    @GetMapping("/api/")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PutMapping("/api/follow")
    public void follow(@RequestBody UserActionDto userActionDto){
        userService.follow(userActionDto);
    }

    @PutMapping("/api/unfollow")
    public void unfollow(@RequestBody UserActionDto userActionDto){
        userService.unfollow(userActionDto);
    }


}
