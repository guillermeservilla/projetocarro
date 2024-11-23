package com.hackaton.projetocarro.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    Long id;
    String name;
    String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    String password;

    public UserDTO(
            Long id,
            String name,
            String email
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

}
