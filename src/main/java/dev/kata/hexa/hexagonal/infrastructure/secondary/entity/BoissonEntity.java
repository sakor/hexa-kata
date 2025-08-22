package dev.kata.hexa.hexagonal.infrastructure.secondary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BoissonEntity {

    private String nomBoisson;
    private double prix;

}
