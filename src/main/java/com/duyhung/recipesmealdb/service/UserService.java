package com.duyhung.recipesmealdb.service;

import com.duyhung.recipesmealdb.entity.User;
import com.duyhung.recipesmealdb.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(User user) throws Exception {
        Optional<User> userExists = userRepository.findByUsername(user.getUsername());
        if (userExists.isPresent()) {
            throw new Exception("User already exist");
        }
        user.setCreated_at(new Date().toString());
        userRepository.save(user);
    }

    public User login(String username, String password) throws Exception {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        if (user.isEmpty())
            throw new Exception("Wrong email or password!");
        return user.get();
    }

    public List<User> searchUserByName(String queryUsername){
        return userRepository.findAllByUsername(queryUsername);
    }

}
