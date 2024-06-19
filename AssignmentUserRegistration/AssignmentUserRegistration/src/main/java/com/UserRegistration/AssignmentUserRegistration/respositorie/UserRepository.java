package com.UserRegistration.AssignmentUserRegistration.respositorie;

import com.UserRegistration.AssignmentUserRegistration.model.UserRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserRegistration, Long> {
    Optional<UserRegistration> findByEmail(String email);
}
