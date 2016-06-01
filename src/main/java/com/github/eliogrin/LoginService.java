package com.github.eliogrin;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    public UserData loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserData();
    }
}
