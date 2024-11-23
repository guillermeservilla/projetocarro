package com.hackaton.projetocarro.core.usecase;

import com.hackaton.projetocarro.core.dto.UserDTO;
import com.hackaton.projetocarro.core.entity.UserEntity;
import com.hackaton.projetocarro.core.exception.ValidationException;
import com.hackaton.projetocarro.core.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateUser {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUser(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserEntity execute(UserEntity user) {
        this.validate(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    private void validate(UserEntity user) {

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new ValidationException("Informe um nome válido");
        }

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new ValidationException("Informe um email válido");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new ValidationException("Informe uma senha");
        }

        if (user.getPassword().length() < 8) {
            throw new ValidationException("A senha deve ter pelo menos 8 caracteres");
        }

        Optional<UserDTO> userOpt = this.userRepository.findByEmail(user.getEmail());

        if (userOpt.isPresent()) {
            throw new ValidationException("O e-mail informado já está sendo utilizado");
        }

    }

}
