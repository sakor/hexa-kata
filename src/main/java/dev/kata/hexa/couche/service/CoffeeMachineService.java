package dev.kata.hexa.couche.service;

import dev.kata.hexa.couche.bean.Payment;
import dev.kata.hexa.couche.dao.BoissonDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CoffeeMachineService {

    private final BoissonDAO boissonDAO;

    public String orderDrink(String nomBoisson, Payment payment) {
        var boisson = boissonDAO.findByName(nomBoisson);

        if (boisson == null) {
            return "Boisson inconnue.";
        }

        if (payment.getAmount() >= boisson.getPrice()) {
            return "Voici votre " + boisson.getName();
        } else {
            return "Montant insuffisant (Prix : " + boisson.getPrice() + "€)";
        }
    }
}
