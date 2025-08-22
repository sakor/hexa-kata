// application/CoffeeMachineController.java
package com.example.coffeemachine.application;

import com.example.coffeemachine.domain.model.*;
import com.example.coffeemachine.domain.ports.in.CoffeeMachineUseCase;

import java.util.Scanner;

public class CoffeeMachineController {
    private final CoffeeMachineUseCase coffeeMachine;

    public CoffeeMachineController(CoffeeMachineUseCase coffeeMachine) {
        this.coffeeMachine = coffeeMachine;
    }

    public void run() {
        var scanner = new Scanner(System.in);
        System.out.println("Bienvenue à la machine à café !");
        System.out.println("Choisissez une boisson (expresso = 1€, cappuccino = 1.5€, thé = 1€) : ");
        String drinkName = scanner.nextLine();
        Drink drink = switch (drinkName.toLowerCase()) {
            case "expresso" -> new Drink("Expresso", 1.0);
            case "cappuccino" -> new Drink("Cappuccino", 1.5);
            case "the" -> new Drink("Thé", 1.0);
            default -> null;
        };

        if (drink == null) {
            System.out.println("Boisson inconnue.");
            return;
        }

        System.out.println("Montant inséré : ");
        double amount = scanner.nextDouble();
        Payment payment = new Payment(amount, "cash");

        coffeeMachine.order(drink, payment);
    }
}
