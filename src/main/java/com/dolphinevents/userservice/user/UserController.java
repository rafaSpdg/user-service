package com.dolphinevents.userservice.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
public class UserController {
    
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<User> getOneUser(@PathVariable Integer id)throws UserNotFoundException {
         
        User user = userService.findUserById(id);

        if(user == null ) {
            throw new UserNotFoundException("Id: " + id);
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());

        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {

        User savedUser =userService.saveUser(user);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(savedUser.getId())
        .toUri();
        
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void removeUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id, @RequestBody User user) throws UserNotFoundException {
        
        User updateUser = userService.findUserById(id);

        if(user == null) {
            throw new UserNotFoundException("User not exist with id: " + id);
        }

        updateUser.setAddress(updateUser.getAddress());
        updateUser.setBirthdate(updateUser.getBirthdate());
        updateUser.setEmail(updateUser.getEmail());
        updateUser.setName(updateUser.getName());
        updateUser.setPassword(updateUser.getPassword());
        updateUser.setPhone(updateUser.getPhone());

        userService.saveUser(updateUser);
        
        return ResponseEntity.ok(updateUser);
    }
}
