package dev.kata.hexa.hexagonal.application.port.out;

import dev.kata.hexa.hexagonal.domain.Boisson;
import org.jmolecules.architecture.hexagonal.SecondaryPort;

@SecondaryPort
public interface BoissonPort {

    Boisson rechercheBoisson(String nomBoisson);

}
