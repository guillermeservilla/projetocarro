package com.hackaton.projetocarro.core.repository;

import com.hackaton.projetocarro.core.dto.MaintenanceDTO;
import com.hackaton.projetocarro.core.entity.MaintenanceEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceEntity, Long> {

    @Query(
            "  SELECT new com.hackaton.projetocarro.core.dto.MaintenanceDTO( "
                    + "       m.id, "
                    + "       m.service, "
                    + "       m.kilometer, "
                    + "       m.date "
                    + "     ) "
                    + "  FROM tbl_manutencao m "
                    + " WHERE m.car.id = :carId "
    )
    Page<MaintenanceDTO> findByCar(
            @Param("carId") Long carId,
            Pageable pageable);

}
