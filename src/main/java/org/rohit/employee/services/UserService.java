package org.rohit.employee.services;

import org.rohit.employee.domain.User;
import org.rohit.employee.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UUID generateUUID(){
        return UUID.randomUUID();
    }

    public User createUser(User user){
        User newuser = new User();
//        newuser.setId(this.generateUUID());
//        newuser.setCreated_at(this.getDateTime());
        return this.userRepo.save(user);
    }

    public List<User> getUsers(){
        return this.userRepo.findAll();
    }
    public User getUser(String username){
        return this.userRepo.findByUsername(username);
    }


}
