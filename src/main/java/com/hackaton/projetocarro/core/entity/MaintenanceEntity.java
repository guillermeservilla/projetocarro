package com.hackaton.projetocarro.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tbl_manutencao")
public class MaintenanceEntity {

    @Id
    @Column(name = "id_manutencao")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "servico_manutencao")
    String service;

    @Column(name = "quilometragem_manutencao")
    Long kilometer;

    @Column(name = "data_manutencao")
    LocalDate date;

    @JoinColumn(name = "id_carro")
    @ManyToOne(fetch = FetchType.LAZY)
    CarEntity car;

}
