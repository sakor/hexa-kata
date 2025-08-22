package dev.kata.hexa.hexagonal.infrastructure.secondary.entity;

import dev.kata.hexa.hexagonal.domain.Boisson;

public class BoissonMapper {

    public static Boisson mapToBoisson(BoissonEntity boisson) {
        if (boisson == null) return null;
        return new Boisson(boisson.getNomBoisson(), boisson.getPrix());
    }

}
