package com.mrizkisaputra.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginUserRequestDTO {
    @NotNull(message = "{login-user-dto.username.notnull}")
    @NotBlank(message = "{login-user-dto.username.notblank}")
    private String username;

    @NotNull(message = "{login-user-dto.password.notnull}")
    @NotBlank(message = "{login-user-dto.password.notblank}")
    private String password;
}
