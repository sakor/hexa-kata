package dev.kata.hexa.hexagonal.application.port.in;

import dev.kata.hexa.hexagonal.infrastructure.primary.rest.PaiementDTO;
import org.jmolecules.architecture.hexagonal.PrimaryPort;

@PrimaryPort
public interface MachineACafePort {

    String commandeBoisson(String boissonCommande, boolean sucre, PaiementDTO paiementDTO);

}
