package com.sanix.Twitter.security;

import com.sanix.Twitter.models.User;
import com.sanix.Twitter.repositories.PersonRepository;
import com.sanix.Twitter.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

import static java.util.Collections.singletonList;


public class UserDetailsServiceImpl implements UserDetailsService {

    private final PersonRepository personRepository;

    public UserDetailsServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
        try {
            final User userOptional = personRepository.findByEmailIgnoreCase(username);

            if(userOptional != null){
                PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
                String password = encoder.encode(userOptional.getPassword());


                return new org.springframework.security
                        .core.userdetails.User.withUsername(userOptional.getEmail())
                        .password(password).build();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        throw new UsernameNotFoundException(username);
    }

}
