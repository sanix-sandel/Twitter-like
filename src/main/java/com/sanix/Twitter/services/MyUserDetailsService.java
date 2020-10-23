package com.sanix.Twitter.services;

import com.sanix.Twitter.models.MyUserDetails;
import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

import static java.util.Collections.singletonList;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Optional<User> user=userRepository.findByUsername(username);

        user.orElseThrow(()->new UsernameNotFoundException("No User "+"found with username: "+username));

        return user.map(MyUserDetails::new).get();

    }


}

