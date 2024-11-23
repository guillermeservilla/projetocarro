package com.hackaton.projetocarro.core.repository;

import com.hackaton.projetocarro.core.dto.CarDTO;
import com.hackaton.projetocarro.core.entity.CarEntity;
import com.hackaton.projetocarro.core.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    @Query(
            "  SELECT new com.hackaton.projetocarro.core.dto.CarDTO( "
            + "       c.id, "
            + "       c.model, "
            + "       c.year, "
            + "       c.brand, "
            + "       c.plate "
            + "     ) "
            + "  FROM tbl_carro c "
            + " WHERE c.plate = :plate "
    )
    Optional<CarDTO> findByPlate(
            @Param("plate") String plate
    );

    @Query(
            "  SELECT new com.hackaton.projetocarro.core.dto.CarDTO( "
                    + "       c.id, "
                    + "       c.model, "
                    + "       c.year, "
                    + "       c.brand, "
                    + "       c.plate "
                    + "     ) "
                    + "  FROM tbl_carro c "
                    + " WHERE c.user.id = :id "
    )
    Page<CarDTO> findByUser(
            @Param("id") Long id,
            Pageable pageable
    );

}
