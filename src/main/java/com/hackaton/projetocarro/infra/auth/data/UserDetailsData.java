package com.hackaton.projetocarro.infra.auth.data;

import java.util.ArrayList;
import java.util.Collection;

import com.hackaton.projetocarro.core.dto.UserDTO;
import com.hackaton.projetocarro.core.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsData implements UserDetails {

    private static final long serialVersionUID = -3827811338806117249L;
    private final UserDTO user;

    public UserDetailsData(UserDTO user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return this.user != null ? this.user.getPassword() : null;
    }

    @Override
    public String getUsername() {
        return this.user != null ? this.user.getEmail() : null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
