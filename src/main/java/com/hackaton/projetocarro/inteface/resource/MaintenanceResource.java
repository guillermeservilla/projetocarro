package com.hackaton.projetocarro.inteface.resource;

import com.hackaton.projetocarro.core.dto.MaintenanceDTO;
import com.hackaton.projetocarro.core.entity.CarEntity;
import com.hackaton.projetocarro.core.entity.MaintenanceEntity;
import com.hackaton.projetocarro.core.usecase.CreateMaintenance;
import com.hackaton.projetocarro.core.usecase.GetMaintenancesByCar;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("maintenance")
public class MaintenanceResource {

    private final CreateMaintenance createMaintenance;
    private final GetMaintenancesByCar getMaintenancesByCar;

    public MaintenanceResource(
            CreateMaintenance createMaintenance,
            GetMaintenancesByCar getMaintenancesByCar
    ) {
        this.createMaintenance = createMaintenance;
        this.getMaintenancesByCar = getMaintenancesByCar;
    }

    @PostMapping
    ResponseEntity<MaintenanceEntity> createCar(
            @RequestBody MaintenanceEntity maintenance
    ) {
        return ResponseEntity.ok(this.createMaintenance.execute(maintenance));
    }

    @GetMapping
    ResponseEntity<Page<MaintenanceDTO>> getCarByUser(
            @RequestParam("idCar") Long idCar,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ) {
        return ResponseEntity.ok(this.getMaintenancesByCar.execute(idCar, page, size));
    }

}
