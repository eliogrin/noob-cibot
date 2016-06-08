package com.github.eliogrin;

import com.github.eliogrin.models.ConsumerModel;
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
    ConsumerData consumerData;

    public ConsumerData loadUserByUsername(String username) throws UsernameNotFoundException {
        ConsumerModel user = factory.getModel(ConsumerModel.class);
        user.data().setName(username);
        user.load();
        if (user.data().getId() == 0) {
            throw new UsernameNotFoundException("Specified user not found.");
        }
        consumerData.setUserData(user.data());
        return consumerData;
    }
}
