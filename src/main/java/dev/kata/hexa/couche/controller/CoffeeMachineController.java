package dev.kata.hexa.couche.controller;

import dev.kata.hexa.couche.bean.Payment;
import dev.kata.hexa.couche.service.CoffeeMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cafe")
@RequiredArgsConstructor
public class CoffeeMachineController {

    private final CoffeeMachineService service;

    @PostMapping("/commande")
    public ResponseEntity<String> orderDrink(@RequestParam String boisson, @RequestParam(defaultValue = "false") Boolean sucre, @RequestBody Payment payment) {
        var result = service.orderDrink(boisson, sucre, payment);
        return ResponseEntity.ok(result);
    }
}