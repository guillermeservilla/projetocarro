package com.hackaton.projetocarro.infra.auth.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackaton.projetocarro.core.entity.UserEntity;
import com.hackaton.projetocarro.infra.auth.data.UserDetailsData;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class JWTAuthFilter extends UsernamePasswordAuthenticationFilter {

    public static final int TOKEN_EXPIRACAO = 60000000;
    public static final String TOKEN_SENHA = "463408a1-54c9-4307-bb1c-6cced559f5a7";

    public JWTAuthFilter(AuthenticationManager authenticationManager) throws Exception {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {

            UserEntity usuario = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);

            return super.getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
                    usuario.getEmail(), usuario.getPassword(), new ArrayList<>()));

        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuario", e);
        } catch (NullPointerException e) {
            throw new RuntimeException("Falha ao autenticar usuario", e);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            this.responseWriter(response, "Usuário ou senha inválidos");
        }

        return null;

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailsData usuarioData = (UserDetailsData) authResult.getPrincipal();

        String token = JWT.create().withSubject(usuarioData.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                .sign(Algorithm.HMAC512(TOKEN_SENHA));

        this.responseWriter(response, token);
    }

    protected void responseWriter(HttpServletResponse response, String message) {

        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(message);
            response.getWriter().flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}
