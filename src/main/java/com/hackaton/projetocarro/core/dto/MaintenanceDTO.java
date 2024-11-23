package com.hackaton.projetocarro.core.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MaintenanceDTO {

    Long id;
    String service;
    Long kilometer;
    LocalDate date;
    CarDTO car;

    public MaintenanceDTO(
            Long id,
            String service,
            Long kilometer,
            LocalDate date
    ) {
        this.id = id;
        this.service = service;
        this.kilometer = kilometer;
        this.date = date;
    }

}
