package com.coderlancce.Service;

import com.coderlancce.Entity.User;
import com.coderlancce.Entity.UserRol;

import java.util.Set;

public interface UserService {
    public User addUser(User user, Set<UserRol> userRoles) throws Exception;

    public User getUser(String username);

    public void deleteUser(Long userId);
}
