package com.hackaton.projetocarro.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "tbl_carro")
public class CarEntity {

    @Id
    @Column(name = "id_carro")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "modelo_carro")
    String model;

    @Column(name = "ano_carro")
    Integer year;

    @Column(name = "marca_carro")
    String brand;

    @Column(name = "placa_carro")
    String plate;

    @JsonIgnore
    @JoinColumn(name = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    UserEntity user;

}
