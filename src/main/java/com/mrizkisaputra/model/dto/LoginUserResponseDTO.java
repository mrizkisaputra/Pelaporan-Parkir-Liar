package com.mrizkisaputra.model.dto;

import com.mrizkisaputra.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUserResponseDTO {
    private User user;
    private String jwt;
}
