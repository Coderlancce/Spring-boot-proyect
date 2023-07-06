    package com.coderlancce.controller;

    import com.coderlancce.Entity.Rol;
    import com.coderlancce.Entity.User;
    import com.coderlancce.Entity.UserRol;
    import com.coderlancce.Repository.UserRepository;
    import com.coderlancce.Service.UserService;
    import org.springframework.web.bind.annotation.*;

    import java.util.HashSet;
    import java.util.List;
    import java.util.Set;

    @RestController
    public class UserController {

        private UserService userService;
        private UserRepository userRepository;

        public UserController(UserService userService, UserRepository userRepository){
            this.userService = userService;
            this.userRepository = userRepository;
        }

        @PostMapping("/users")
        public User addUser(@RequestBody User user) throws Exception{
            Set<UserRol> roles = new HashSet<>();

            Rol rol = new Rol();
            rol.setRolId(2L);
            rol.setName("NORMAL");

            UserRol userRol = new UserRol();
            userRol.setUser(user);
            userRol.setRol(rol);

            return userService.addUser(user, roles);
        }

        @GetMapping("/users")
        public List<User> getUsers(){
            return userRepository.findAll();
        }

        @GetMapping("/users/{username}")
        public User getUser(@PathVariable("username") String username){
            return userService.getUser(username);
        }

        @DeleteMapping("/users/{userId}")
        public void deleteUser(@PathVariable("userId")Long userId){
            userService.deleteUser(userId);
        }
    }
