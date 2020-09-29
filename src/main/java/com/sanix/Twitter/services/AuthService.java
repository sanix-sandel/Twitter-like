package com.sanix.Twitter.services;
/*
import com.sanix.Twitter.Dto.UserAuthentication;
import com.sanix.Twitter.Dto.UserRegistration;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    //private final AuthenticationManager authenticationManager;
    //private final JwtProvider jwtProvider;


    public AuthService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        //this.authenticationManager=authenticationManager;
        //this.jwtProvider=jwtProvider;
    }

    public void signup(UserRegistration userRegistration){
        User user=new User();
        user.setUsername(userRegistration.getUsername());
        user.setEmail(userRegistration.getEmail());
        user.setPassword(passwordEncoder.encode(userRegistration.getPassword()));
        userRepository.save(user);
    }

    /*public String login(UserAuthentication userAuthentication){
        Authentication authenticate=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuthentication.getUsername(),
                userAuthentication.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        return jwtProvider.generateToken(authenticate);

    }
}
*/