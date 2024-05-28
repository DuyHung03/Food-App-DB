package com.duyhung.recipesmealdb.controller;


import com.duyhung.recipesmealdb.entity.Response;
import com.duyhung.recipesmealdb.entity.User;
import com.duyhung.recipesmealdb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response<User>> register(@RequestBody User user) {
        try {
            userService.register(user);
            return ResponseEntity.ok(new Response<>(200, null, user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(400, e.getMessage(), null));
        }
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(
            @RequestParam String username,
            @RequestParam String password
    ) {
        try {
            User user = userService.login(username, password);
            return ResponseEntity.ok(new Response<>(200, null, user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(400, e.getMessage(), null));
        }
    }

    @GetMapping("/user/search")
    public ResponseEntity<?> searchUserByName(@RequestParam String username) {
        try {
            List<User> users = userService.searchUserByName(username);
            return ResponseEntity.ok(new Response<>(200, null, users));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new Response<>(400, e.getMessage(), null));
        }
    }

}
