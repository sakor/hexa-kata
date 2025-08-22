package dev.kata.hexa.hexagonal.infrastructure.secondary.message;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessagerEnHexagonal {

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
