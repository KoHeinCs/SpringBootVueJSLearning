package com.ashwetaw.springbootgenericcrud.service;

import com.ashwetaw.springbootgenericcrud.config.security.SpringSecurityUser;
import com.ashwetaw.springbootgenericcrud.entities.User;
import com.ashwetaw.springbootgenericcrud.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.ashwetaw.springbootgenericcrud.constants.MessageConstant.*;

/**
 * @author koheincs
 * @created at 02/05/2024
 **/
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MSG + username));

        if (Objects.nonNull(user)){
            return new SpringSecurityUser(user);
        }

        return null;
    }

}
