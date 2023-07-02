package com.coderlancce.Service.IMPL;

import com.coderlancce.Entity.User;
import com.coderlancce.Entity.UserRol;
import com.coderlancce.Repository.RolRepository;
import com.coderlancce.Repository.UserRepository;
import com.coderlancce.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImplementation implements UserService {
    private UserRepository userRepository;
    private RolRepository rolRepository;

    @Override
    public User addUser(User user, Set<UserRol> userRols) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null){
            throw new Exception("User alredy is present");
        } else {
            for(UserRol userRol: userRols){
                rolRepository.save(userRol.getRol());
            }
            user.getUserRols().addAll(userRols);
            localUser = userRepository.save(user);
        }
        return localUser;
    }
}
