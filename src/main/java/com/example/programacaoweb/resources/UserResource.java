package com.example.programacaoweb.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.programacaoweb.entities.User;
import com.example.programacaoweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok().body(users);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id).orElse(null);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.update(user);
        return ResponseEntity.ok().body(updatedUser);
    }
}
