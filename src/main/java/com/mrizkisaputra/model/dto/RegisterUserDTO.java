package com.mrizkisaputra.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterUserDTO {
    @NotNull(message = "{register-user-dto.username.notnull}")
    @NotBlank(message = "{register-user-dto.username.notblank}")
    private String username;

    @NotNull(message = "{register-user-dto.password.notnull}")
    @NotBlank(message = "{register-user-dto.password.notblank}")
    private String password;
}
