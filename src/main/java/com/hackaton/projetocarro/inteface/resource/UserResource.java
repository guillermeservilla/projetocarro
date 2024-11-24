package com.hackaton.projetocarro.inteface.resource;

import com.hackaton.projetocarro.core.entity.UserEntity;
import com.hackaton.projetocarro.core.usecase.CreateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserResource {

    private final CreateUser createUser;

    public UserResource(
            CreateUser createUser

    ) {
        this.createUser = createUser;
    }

    @PostMapping
    ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
        return ResponseEntity.ok(this.createUser.execute(user));
    }

}
