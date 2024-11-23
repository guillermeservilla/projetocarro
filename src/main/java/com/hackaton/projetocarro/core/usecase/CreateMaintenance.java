package com.hackaton.projetocarro.core.usecase;

import com.hackaton.projetocarro.core.entity.MaintenanceEntity;
import com.hackaton.projetocarro.core.repository.MaintenanceRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CreateMaintenance {

    private final MaintenanceRepository maintenanceRepository;

    public CreateMaintenance(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public MaintenanceEntity execute(MaintenanceEntity maintenance) {

        if (maintenance.getDate() == null) {
            maintenance.setDate(LocalDate.now());
        }

        return this.maintenanceRepository.save(maintenance);
    }

}
