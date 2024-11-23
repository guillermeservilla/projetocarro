package com.hackaton.projetocarro.core.usecase;

import com.hackaton.projetocarro.core.dto.CarDTO;
import com.hackaton.projetocarro.core.entity.CarEntity;
import com.hackaton.projetocarro.core.entity.UserEntity;
import com.hackaton.projetocarro.core.repository.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class GetCarsByUser {

    private final CarRepository carRepository;
    private final GetLoggedUser getLoggedUser;

    public GetCarsByUser(
            CarRepository carRepository,
            GetLoggedUser getLoggedUser
    ) {
        this.carRepository = carRepository;
        this.getLoggedUser = getLoggedUser;
    }

    public Page<CarDTO> execute(Integer page, Integer size) {
        return this.carRepository.findByUser(
                getLoggedUser.getLoggedUserId(),
                PageRequest.of(page, size)
        );
    }

}
