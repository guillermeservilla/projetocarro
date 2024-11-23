package com.hackaton.projetocarro.core.usecase;

import com.hackaton.projetocarro.core.dto.UserDTO;
import com.hackaton.projetocarro.core.entity.UserEntity;
import com.hackaton.projetocarro.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class GetLoggedUser {

    @Autowired
    private UserRepository userRepositoy;

    @Cacheable("loggedUserObj")
    public UserDTO getLoggedUserObj() {
        return this.userRepositoy.findByEmail(SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString()).orElseThrow();
    }

    @Cacheable("loggedUserId")
    public Long getLoggedUserId() {
        return this.getLoggedUserObj().getId();
    }

}