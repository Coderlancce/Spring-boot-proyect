package com.coderlancce.Service;

import com.coderlancce.Entity.User;
import com.coderlancce.Entity.UserRol;

import java.util.Set;

public interface UserService {
    public User addUser(User user, Set<UserRol> userRols) throws Exception;
}
