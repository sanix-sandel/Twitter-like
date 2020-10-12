package com.sanix.Twitter.api;

import com.sanix.Twitter.Dto.ContactDTO;
import com.sanix.Twitter.Dto.UserActionDto;
import com.sanix.Twitter.Dto.UserAuthentication;
import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;
//import com.sanix.Twitter.services.AuthService;
import com.sanix.Twitter.services.AuthService;
import com.sanix.Twitter.services.FollowService;
import com.sanix.Twitter.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/users")
public class UserController {


    //private final AuthService authService;
    private final UserService userService;
    private final FollowService followService;


    public UserController( UserService userService/*, AuthService authService*/,
                           FollowService followService) {
      //  this.authService = authService;
        this.userService=userService;
        this.followService=followService;

    }

    @RequestMapping("/signup")
    public void create_user(@RequestBody UserRegistration userRegistration){
        userService.createUser(userRegistration);
    }

   /* @RequestMapping("/signup")
    public ResponseEntity<String> create_user(@RequestBody UserRegistration userRegistration){
        authService.signup(userRegistration);
        return new ResponseEntity<>("User registered", OK);
    }*/



    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PutMapping("/follow")
    public void follow(@RequestBody ContactDTO contactDTO){
        followService.follow(contactDTO);
    }
    /*
    @PutMapping("/api/unfollow")
    public void unfollow(@RequestBody UserActionDto userActionDto){
        userService.unfollow(userActionDto);
    }*/

    /*@GetMapping()
    public void getFollowers(){

    }

    @GetMapping()
    public void getFollowings(){

    }*/


}
