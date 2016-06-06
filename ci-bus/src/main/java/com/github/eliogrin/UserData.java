package com.github.eliogrin;

import com.github.eliogrin.dto.UserDto;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Service object for login functionality.
 */

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserData implements UserDetails {

    private String username;
    private String password;

    public boolean isEnabled() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorities;
    }

    public void setUserData(UserDto userData) {
        username = userData.getName();
        password = userData.getPassword();
    }
}
