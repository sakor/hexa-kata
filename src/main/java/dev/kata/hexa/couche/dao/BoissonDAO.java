package dev.kata.hexa.couche.dao;

import dev.kata.hexa.couche.bean.Boisson;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BoissonDAO {

    private static final Map<String, Boisson> boissons = new HashMap<>();

    static {
        boissons.put("expresso", new Boisson("Expresso", 1.0));
        boissons.put("cappuccino", new Boisson("Cappuccino", 1.5));
        boissons.put("the", new Boisson("Thé", 1.0));
    }

    public Boisson findByName(String name) {
        return boissons.get(name.toLowerCase());
    }

}
