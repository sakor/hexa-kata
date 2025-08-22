package dev.kata.hexa.hexagonal.infrastructure.secondary;

import dev.kata.hexa.hexagonal.infrastructure.secondary.jpa.BoissonJPA;
import dev.kata.hexa.hexagonal.application.port.out.BoissonPort;
import dev.kata.hexa.hexagonal.domain.Boisson;
import dev.kata.hexa.hexagonal.infrastructure.secondary.entity.BoissonMapper;
import dev.kata.hexa.hexagonal.infrastructure.secondary.message.MessagerEnHexagonal;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@SecondaryAdapter
public class BoissonAdapter implements BoissonPort {

    private final BoissonJPA boissonJPA;
    private final MessagerEnHexagonal messager;

    @Override
    public Boisson rechercheBoisson(String nomBoisson) {
        messager.envoyer(nomBoisson);
        var boisson = boissonJPA.findByName(nomBoisson);
        return BoissonMapper.mapToBoisson(boisson);
    }

}
