package org.rohit.employee.controller;

import org.rohit.employee.domain.User;
import org.rohit.employee.repo.UserRepo;
import org.rohit.employee.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class UserController {
    private final UserRepo userRepo;
    private final UserService userService;



    public UserController(UserRepo userRepo, UserService userService) {
        this.userRepo = userRepo;
        this.userService = userService;
    }

    @GetMapping
    public List<User> getEmployee(){
        System.out.println("hello world"+this.userService.getUsers().toString());
        return this.userService.getUsers();
    }

    @GetMapping("/{username}")
    public User getSingleEmployee(@PathVariable("username") String username ){
        System.out.println(username);
        return this.userService.getUser(username);
    }
    @PostMapping
    public User create(@RequestBody User user){
        System.out.println("hello"+ " "+user.getUsername());
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setCreated_at(new Date());
        newUser.setUpdated_at(new Date());
        newUser.setSalt("mysalatalf");
        return this.userRepo.save(newUser);
    }
}
