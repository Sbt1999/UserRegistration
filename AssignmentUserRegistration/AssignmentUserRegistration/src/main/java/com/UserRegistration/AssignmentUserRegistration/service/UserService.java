package com.UserRegistration.AssignmentUserRegistration.service;

import com.UserRegistration.AssignmentUserRegistration.model.UserRegistration;

public interface UserService {
    UserRegistration signup(String name, String email, String password);

    UserRegistration fetchUserByEmail(String email);
}
