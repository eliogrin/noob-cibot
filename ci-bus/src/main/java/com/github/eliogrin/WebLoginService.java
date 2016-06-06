package com.github.eliogrin;

import com.github.eliogrin.models.UserModel;
import com.github.eliogrin.models.core.ModelFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class WebLoginService implements UserDetailsService {

    @Autowired
    ModelFactory factory;

    @Autowired
    UserData userData;

    public UserData loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = factory.getModel(UserModel.class);
        user.data().setName(username);
        user.load();
        userData.setUserData(user.data());
        return userData;
    }
}
