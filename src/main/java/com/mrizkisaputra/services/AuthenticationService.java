package com.mrizkisaputra.services;

import com.mrizkisaputra.model.dto.RegisterUserDTO;
import com.mrizkisaputra.model.entity.Role;
import com.mrizkisaputra.model.entity.User;
import com.mrizkisaputra.model.response.ApiSuccess;
import com.mrizkisaputra.repositories.RoleRepository;
import com.mrizkisaputra.repositories.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import static com.mrizkisaputra.model.entity.ApplicationRole.USER_PELAPOR;

@Service
public class AuthenticationService implements MessageSourceAware {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private Validator validator;
    private MessageSource messageSource;

    @Transactional
    public ResponseEntity<ApiSuccess<User>> registerUser(RegisterUserDTO userDTO) {
        // validasi request http body
        Set<ConstraintViolation<RegisterUserDTO>> validated = validator.validate(userDTO);
        if (!validated.isEmpty()) {
            throw new ConstraintViolationException(messageSource.getMessage("validation-failed", null, Locale.getDefault()), validated);
        }

        // validasi uniq username
        boolean exists = userRepository.existsByUsername(userDTO.getUsername());
        if (exists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, messageSource.getMessage("already-username", null, Locale.getDefault()));
        }

        String encodedPassword = passwordEncoder.encode(userDTO.getPassword());
        Role role = roleRepository.findByAuthority(USER_PELAPOR).get();
        User user = new User(userDTO.getUsername(), encodedPassword, Set.of(role));
        userRepository.save(user);
        ApiSuccess<User> apiSuccess = new ApiSuccess<>(HttpStatus.CREATED, messageSource.getMessage("register-success", null, Locale.getDefault()), List.of(user), null);
        return buildResponseEntity(apiSuccess);
    }

    private ResponseEntity<ApiSuccess<User>> buildResponseEntity(ApiSuccess<User> apiSuccess) {
        return new ResponseEntity<>(apiSuccess, HttpStatus.CREATED);
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
