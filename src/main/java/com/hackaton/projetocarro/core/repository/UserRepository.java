package com.hackaton.projetocarro.core.repository;

import com.hackaton.projetocarro.core.dto.UserDTO;
import com.hackaton.projetocarro.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(
            "  SELECT new com.hackaton.projetocarro.core.dto.UserDTO( "
                    + "       u.id, "
                    + "       u.name, "
                    + "       u.email "
                    + "     ) "
                    + "  FROM tbl_usuario u "
                    + " WHERE u.email = :email "
    )
    Optional<UserDTO> findByEmail(
            @Param("email") String email
    );

}
