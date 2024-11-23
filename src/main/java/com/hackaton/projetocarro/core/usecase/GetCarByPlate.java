package com.hackaton.projetocarro.core.usecase;

import com.hackaton.projetocarro.core.dto.CarDTO;
import com.hackaton.projetocarro.core.entity.CarEntity;
import com.hackaton.projetocarro.core.repository.CarRepository;
import org.springframework.stereotype.Component;

@Component
public class GetCarByPlate {

    private final CarRepository carRepository;

    public GetCarByPlate(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarDTO execute(String plate) {
        return this.carRepository.findByPlate(plate).orElseThrow();
    }

}
