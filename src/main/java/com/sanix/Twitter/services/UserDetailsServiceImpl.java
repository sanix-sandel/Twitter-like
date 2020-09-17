package com.sanix.Twitter.services;

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
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username){
        Optional<User> userOptional=userRepository.findByUsername(username);
        User user=userOptional.orElseThrow(()->new UsernameNotFoundException("No user "+
                "Found with username: "+ username));

        return new org.springframework.security
                .core.userdetails.User(user.getUsername(), user.getPassword(),
                                        true, true, true, true, getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role_user){
        return singletonList(new SimpleGrantedAuthority(role_user));
    }
}
