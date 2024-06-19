package com.UserRegistration.AssignmentUserRegistration.service;

import com.UserRegistration.AssignmentUserRegistration.exception.UserNotFoundException;
import com.UserRegistration.AssignmentUserRegistration.model.UserRegistration;
import com.UserRegistration.AssignmentUserRegistration.respositorie.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserRegistration signup(String name, String email, String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserRegistration user = new UserRegistration();
        user.setName(name);
        user.setPassword(encoder.encode(password));
        user.setEmail(email);
        return userRepository.save(user);
    }

//    @Override
//    public UserRegistration fetchByEmail(String email) {
//        Optional<UserRegistration> userOptional = userRepository.findByEmail(email);
//        if (userOptional.isPresent()) {
//            return userOptional.get();
//        } else {
//            throw new UserNotFoundException("User not found with email: " + email);
//        }
//    }
    @Override
    public UserRegistration fetchUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
