package com.sanix.Twitter.api;

import com.sanix.Twitter.Dto.*;
import com.sanix.Twitter.models.Contact;
import com.sanix.Twitter.models.User;
//import com.sanix.Twitter.services.AuthService;
import com.sanix.Twitter.services.AuthService;
import com.sanix.Twitter.services.ContactService;
import com.sanix.Twitter.services.FollowService;
import com.sanix.Twitter.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final AuthService authService;
    private final UserService userService;
    private final FollowService followService;
    private final ContactService contactService;


    public UserController( UserService userService, AuthService authService,
                           FollowService followService, ContactService contactService) {
        this.authService = authService;
        this.userService=userService;
        this.followService=followService;
        this.contactService=contactService;

    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public AuthenticationResponse login(@RequestBody UserAuthentication userAuthentication)throws Exception{

        return authService.login(userAuthentication);

    }

    @RequestMapping("/signup")
    public ResponseEntity<String> create_user(@RequestBody UserRegistration userRegistration){
        authService.signup(userRegistration);
        return new ResponseEntity<>("User registered", OK);
    }



    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PutMapping("/follow")
    public void follow(@RequestBody ContactDTO contactDTO){
        followService.follow(contactDTO);
    }

    @GetMapping("/contacts")
    public List<Contact> allContacts(){
        return contactService.findAll();
    }


    @GetMapping("/{id}/followers")
    public List<User> getFollowers(@PathVariable ("id")final Long id){
        User user=userService.findById(id);
        return contactService.getFollowers(user);
    }

    @GetMapping("/{id}/followed")
    public List getFollowings(@PathVariable ("id")final Long id){
        User user=userService.findById(id);
        return contactService.getFollowed(user);

    }




}
