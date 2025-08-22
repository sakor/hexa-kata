package dev.kata.hexa.hexagonal.application.port.out;

import dev.kata.hexa.hexagonal.domain.Boisson;

public interface BoissonPort {

    Boisson rechercheBoisson(String nomBoisson);

}
