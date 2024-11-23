package com.hackaton.projetocarro.core.usecase;

import com.hackaton.projetocarro.core.dto.CarDTO;
import com.hackaton.projetocarro.core.entity.CarEntity;
import com.hackaton.projetocarro.core.entity.UserEntity;
import com.hackaton.projetocarro.core.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateCar {

    private final CarRepository carRepository;
    private final GetLoggedUser getLoggedUser;
    private final ModelMapper modelMapper;

    public CreateCar(
            CarRepository carRepository,
            GetLoggedUser getLoggedUser,
            ModelMapper modelMapper
    ) {
        this.carRepository = carRepository;
        this.getLoggedUser = getLoggedUser;
        this.modelMapper = modelMapper;
    }

    public CarEntity execute(CarEntity car) {
        car = this.validatePlate(car);
        return this.carRepository.save(car);
    }

    private CarEntity validatePlate(CarEntity car) {

        Optional<CarDTO> carOpt = this.carRepository.findByPlate(car.getPlate());
        if (carOpt.isPresent() && carOpt.get().getUser() == null) {
            return modelMapper.map(carOpt.get(), CarEntity.class);
        }

        car.setUser(modelMapper.map(this.getLoggedUser.getLoggedUserObj(), UserEntity.class));
        return car;

    }

}
