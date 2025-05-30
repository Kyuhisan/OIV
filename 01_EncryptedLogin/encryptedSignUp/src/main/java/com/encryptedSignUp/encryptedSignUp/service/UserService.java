package com.encryptedSignUp.encryptedSignUp.service;

import java.util.Optional;
import com.encryptedSignUp.encryptedSignUp.repository.UserRepository;
import com.encryptedSignUp.encryptedSignUp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor 
public class UserService implements UserDetailsService{
    @Autowired
    private UserRepository repository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .build();    
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
