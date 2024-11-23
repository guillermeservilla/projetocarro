package com.hackaton.projetocarro.inteface.resource;

import com.hackaton.projetocarro.core.dto.CarDTO;
import com.hackaton.projetocarro.core.entity.CarEntity;
import com.hackaton.projetocarro.core.usecase.CreateCar;
import com.hackaton.projetocarro.core.usecase.GetCarByPlate;
import com.hackaton.projetocarro.core.usecase.GetCarsByUser;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
public class CarResource {

    private final CreateCar createCar;
    private final GetCarByPlate getCarByPlate;
    private final GetCarsByUser getCarsByUser;

    public CarResource(
            CreateCar createCar,
            GetCarByPlate getCarByPlate,
            GetCarsByUser getCarsByUser
    ) {
        this.createCar = createCar;
        this.getCarByPlate = getCarByPlate;
        this.getCarsByUser = getCarsByUser;
    }

    @PostMapping
    ResponseEntity<CarEntity> createCar(
            @RequestBody CarEntity car
    ) {
        return ResponseEntity.ok(this.createCar.execute(car));
    }

    @GetMapping
    ResponseEntity<CarDTO> getCarByPlate(
            @RequestParam("plate") String plate
    ) {
        return ResponseEntity.ok(this.getCarByPlate.execute(plate));
    }

    @GetMapping("/get-all")
    ResponseEntity<Page<CarDTO>> getCarByUser(
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
    ) {
        return ResponseEntity.ok(this.getCarsByUser.execute(page, size));
    }

}
