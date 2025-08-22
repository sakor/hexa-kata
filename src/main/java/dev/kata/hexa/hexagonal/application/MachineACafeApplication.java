package dev.kata.hexa.hexagonal.application;

import dev.kata.hexa.hexagonal.infrastructure.primary.rest.PaiementDTO;
import dev.kata.hexa.hexagonal.application.port.out.BoissonPort;
import dev.kata.hexa.hexagonal.application.port.in.MachineACafePort;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.Application;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Application
public class MachineACafeApplication implements MachineACafePort {

    private final BoissonPort boissonPort;

    @Override
    public String commandeBoisson(String boissonCommande, boolean sucre, PaiementDTO paiement) {
        var boisson = boissonPort.rechercheBoisson(boissonCommande);

        if (boisson == null) {
            return "Boisson inconnue.";
        }

        var montant = sucre ? boisson.prix() + 0.5 : boisson.prix();

        if (paiement.amount() >= montant) {
            return "Voici votre " + boisson.nom();
        } else {
            return "Montant insuffisant (Prix : " + montant + "€)";
        }
    }

}
