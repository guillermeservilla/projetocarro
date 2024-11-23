package com.hackaton.projetocarro.core.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDTO {

    Long id;
    String model;
    Integer year;
    String brand;
    String plate;
    UserDTO user;

    public CarDTO(
            Long id,
            String model,
            Integer year,
            String brand,
            String plate
    ) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.brand = brand;
        this.plate = plate;
    }

}
