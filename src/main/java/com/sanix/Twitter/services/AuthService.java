package com.sanix.Twitter.services;

import com.sanix.Twitter.Dto.AuthenticationResponse;
import com.sanix.Twitter.Dto.UserAuthentication;
import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import com.sanix.Twitter.security.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final MyUserDetailsService myUserDetailsService;

    public AuthService(PasswordEncoder passwordEncoder,
                       UserRepository userRepository,
                       AuthenticationManager authenticationManager,
                       JwtProvider jwtProvider,
                       MyUserDetailsService myUserDetailsService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.myUserDetailsService = myUserDetailsService;
    }

    public void signup(UserRegistration userRegistration){
        User user=new User();
        user.setUsername(userRegistration.getUsername());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        user.setRoles("USER");
        userRepository.save(user);
    }

    public AuthenticationResponse login(UserAuthentication userAuthentication)throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userAuthentication.getUsername(), userAuthentication.getPassword())
            );
        }catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails=myUserDetailsService.loadUserByUsername(userAuthentication.getUsername());

        final String jwt=jwtProvider.generateToken(userDetails);

        return (new AuthenticationResponse(jwt));

    }

    @Transactional(readOnly = true)
    public User getCurrentUser(){
        org.springframework.security.core.userdetails.User principal=(org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(principal.getUsername())
                .orElseThrow(()->new UsernameNotFoundException("Username not found "+principal.getUsername()));

    }
}
