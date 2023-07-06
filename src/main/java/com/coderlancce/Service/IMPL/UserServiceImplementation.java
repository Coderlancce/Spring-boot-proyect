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

    public UserServiceImplementation(UserRepository userRepository, RolRepository rolRepository){
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    public User addUser(User user, Set<UserRol> userRoles) throws Exception {
        User localUser = userRepository.findByUsername(user.getUsername());
        if (localUser != null){
            throw new Exception("User already is present");
        } else {
            for(UserRol userRol: userRoles){
                rolRepository.save(userRol.getRol());
            }
            user.getUserRoles().addAll(userRoles);
            localUser = userRepository.save(user);
        }
        return localUser;
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
