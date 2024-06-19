package com.UserRegistration.AssignmentUserRegistration.controller;

import com.UserRegistration.AssignmentUserRegistration.DTOs.UserRegistrationRequestDTO;
import com.UserRegistration.AssignmentUserRegistration.DTOs.UserRegistrationResponseDTO;
import com.UserRegistration.AssignmentUserRegistration.exception.UserRegistrationInvalidDataException;
import com.UserRegistration.AssignmentUserRegistration.mappper.EntityDTOMapper;
import com.UserRegistration.AssignmentUserRegistration.model.UserRegistration;
import com.UserRegistration.AssignmentUserRegistration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO){
        validateUserRegistrationRequestDTO(userRegistrationRequestDTO);
        UserRegistration savedUser = userService.signup(userRegistrationRequestDTO.getName(), userRegistrationRequestDTO.getEmail(), userRegistrationRequestDTO.getPassword());
        return ResponseEntity.ok(
                EntityDTOMapper.toDTO(savedUser)
        );
    }

    @GetMapping("/fetch")
    public ResponseEntity<UserRegistrationResponseDTO> fetchByEmail(@RequestParam String email) {
        UserRegistration user = userService.fetchUserByEmail(email);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(EntityDTOMapper.toDTO(user));
    }

    private void validateUserRegistrationRequestDTO(UserRegistrationRequestDTO requestDTO) {
        if (requestDTO.getEmail() == null || requestDTO.getName() == null || requestDTO.getPassword() == null) {
            throw new UserRegistrationInvalidDataException("Invalid sign up data");
        }

        // Validate email format
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(emailPattern, requestDTO.getEmail())) {
            throw new UserRegistrationInvalidDataException("Invalid email format");
        }

        // Validate password requirements: at least 8 characters, including a small, capital, numeric, and special character
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,}$";
        if (!Pattern.matches(passwordPattern, requestDTO.getPassword())) {
            throw new UserRegistrationInvalidDataException("Password must be at least 8 characters long, including one lowercase letter, one uppercase letter, one numeric digit, and one special character");
        }
    }
}
