package dev.kata.hexa.hexagonal.infrastructure.secondary.jpa;

import dev.kata.hexa.hexagonal.infrastructure.secondary.entity.BoissonEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("BoisonDAOHexa")
public class BoissonJPA {

    private static final Map<String, BoissonEntity> boissons = new HashMap<>();

    static {
        boissons.put("expresso", new BoissonEntity("Expresso", 1.0));
        boissons.put("cappuccino", new BoissonEntity("Cappuccino", 1.5));
        boissons.put("the", new BoissonEntity("Thé", 1.0));
    }

    public BoissonEntity findByName(String name) {
        return boissons.get(name.toLowerCase());
    }

}
