package com.hackaton.projetocarro.core.usecase;

import com.hackaton.projetocarro.core.entity.CarEntity;
import com.hackaton.projetocarro.core.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RemoveCar {

    private final CarRepository carRepository;

    public RemoveCar(
            CarRepository carRepository
    ) {
        this.carRepository = carRepository;
    }

    public Page<CarEntity> execute(Long idCar) {

        CarEntity car = this.carRepository.findById(idCar).orElseThrow();
        car.setUser(null);

        return null;

    }

}
