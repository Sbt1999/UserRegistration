package com.UserRegistration.AssignmentUserRegistration.mappper;

import com.UserRegistration.AssignmentUserRegistration.DTOs.UserRegistrationResponseDTO;
import com.UserRegistration.AssignmentUserRegistration.model.UserRegistration;

public class EntityDTOMapper {
    public static UserRegistrationResponseDTO toDTO(UserRegistration userRegistration) {
        UserRegistrationResponseDTO dto = new UserRegistrationResponseDTO();
        dto.setId(userRegistration.getId());
        dto.setEmail(userRegistration.getEmail());
        dto.setName(userRegistration.getName());
        return dto;
    }
}
