package dev.kata.hexa.couche.message;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessagerEnCouche {

    private final List<String> messagesEnvoyes = new ArrayList<>();

    public void envoyer(String message) {
        messagesEnvoyes.add(message);
    }

    public List<String> getMessages() {
        return List.copyOf(messagesEnvoyes);
    }

    public void reset() {
        messagesEnvoyes.clear();
    }

}
