package dev.kata.hexa.hexagonal.infrastructure.primary.rest;

import dev.kata.hexa.hexagonal.application.port.in.MachineACafePort;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.PrimaryAdapter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hexa/cafe")
@RequiredArgsConstructor
@PrimaryAdapter // <------ ICI
public class MachineACafeController {

    private final MachineACafePort machineACafePort;

    @PostMapping("/commande")
    public ResponseEntity<String> orderDrink(@RequestParam String boisson, @RequestParam(defaultValue = "false") Boolean sucre, @RequestBody PaiementDTO paiementDTO) {
        var result = machineACafePort.commandeBoisson(boisson, sucre, paiementDTO);
        return ResponseEntity.ok(result);
    }

}