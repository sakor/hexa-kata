package dev.kata.hexa.couche.service;

import dev.kata.hexa.couche.bean.Payment;
import dev.kata.hexa.couche.dao.BoissonDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoffeeMachineService {

    private final BoissonDAO boissonDAO;

    public String orderDrink(String nomBoisson, Boolean sucre,Payment payment) {
        var boisson = boissonDAO.findByName(nomBoisson);

        if (boisson == null) {
            return "Boisson inconnue.";
        }

        var montant = sucre ? boisson.getPrice() + 0.5 : boisson.getPrice();

        if (payment.getAmount() >= montant) {
            return "Voici votre " + boisson.getName();
        } else {
            return "Montant insuffisant (Prix : " + montant + "€)";
        }
    }
}
