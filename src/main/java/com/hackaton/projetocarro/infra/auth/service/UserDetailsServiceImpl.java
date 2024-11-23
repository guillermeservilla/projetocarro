package com.hackaton.projetocarro.infra.auth.service;

import com.hackaton.projetocarro.core.dto.UserDTO;
import com.hackaton.projetocarro.core.entity.UserEntity;
import com.hackaton.projetocarro.core.repository.UserRepository;
import com.hackaton.projetocarro.infra.auth.data.UserDetailsData;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDTO> userOpt = this.userRepository.findByEmail(username);

        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }

        return new UserDetailsData(userOpt.get());

    }

}
