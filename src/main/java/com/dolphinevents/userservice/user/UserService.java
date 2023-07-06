package com.dolphinevents.userservice.user;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Integer id) throws UserNotFoundException{
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Could not find an user in the database."));
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public User saveUser(User user) {
        userRepository.save(user);
        return user;   
    }
}
