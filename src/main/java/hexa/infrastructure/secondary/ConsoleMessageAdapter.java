package com.example.coffeemachine.infrastructure.message;

import com.example.coffeemachine.domain.ports.out.MessagePort;

public class ConsoleMessageAdapter implements MessagePort {
    @Override
    public void display(String message) {
        System.out.println("[MESSAGE] " + message);
    }
}
