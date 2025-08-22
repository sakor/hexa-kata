package dev.kata.hexa.hexagonal.application.port.in;

import dev.kata.hexa.hexagonal.infrastructure.primary.rest.PaiementDTO;

public interface MachineACafePort {

    String commandeBoisson(String boissonCommande, boolean sucre, PaiementDTO paiementDTO);

}
