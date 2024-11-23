package com.hackaton.projetocarro.core.usecase;

import com.hackaton.projetocarro.core.dto.MaintenanceDTO;
import com.hackaton.projetocarro.core.entity.CarEntity;
import com.hackaton.projetocarro.core.entity.MaintenanceEntity;
import com.hackaton.projetocarro.core.repository.MaintenanceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GetMaintenancesByCar {

    private final MaintenanceRepository maintenanceRepository;

    public GetMaintenancesByCar(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public Page<MaintenanceDTO> execute(Long idCar, Integer page, Integer size) {

        return this.maintenanceRepository.findByCar(idCar, PageRequest.of(page, size));

    }

}
