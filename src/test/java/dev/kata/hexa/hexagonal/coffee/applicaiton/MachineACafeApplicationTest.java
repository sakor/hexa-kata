package dev.kata.hexa.hexagonal.coffee.applicaiton;

import dev.kata.hexa.hexagonal.domain.Boisson;
import dev.kata.hexa.hexagonal.infrastructure.primary.rest.PaiementDTO;
import dev.kata.hexa.hexagonal.application.MachineACafeApplication;
import dev.kata.hexa.hexagonal.application.port.out.BoissonPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MachineACafeApplicationTest {

    @Mock
    private BoissonPort boissonPort;

    @InjectMocks
    private MachineACafeApplication application;

    @Test
    void orderDrink_WITH_the_no_sugar_and_2_euros_SHOULD_dispense_drink() {
        // Given
        var nomBoisson = "the";
        var montant = 2.0;
        when(boissonPort.rechercheBoisson(nomBoisson)).thenReturn(new Boisson(nomBoisson, montant));

        // When
        var result = application.commandeBoisson(nomBoisson, false ,new PaiementDTO(2.0));

        // Then
        assertThat(result).isEqualTo("Voici votre " + nomBoisson);
    }

    @Test
    void orderDrink_WITH_the_no_sugar_and_1_euros_SHOULD_not_dispense_drink() {
        // Given
        var nomBoisson = "the";
        var montant = 2.0;
        when(boissonPort.rechercheBoisson(nomBoisson)).thenReturn(new Boisson(nomBoisson, montant));

        // When
        var result = application.commandeBoisson(nomBoisson, false, new PaiementDTO(1.0));

        // Then
        assertThat(result).isEqualTo("Montant insuffisant (Prix : " + montant + "€)");
    }

    @Test
    void orderDrink_WITH_unknow_no_sugar_and_2_euros_SHOULD_send_bad_drink_message() {
        // Given
        var nomBoisson = "unknow";
        when(boissonPort.rechercheBoisson(nomBoisson)).thenReturn(null);

        // When
        var result = application.commandeBoisson(nomBoisson, false, new PaiementDTO(2.0));

        // Then
        assertThat(result).isEqualTo("Boisson inconnue.");
    }

    @Test
    void orderDrink_WITH_the_with_sugar_and_2_euros_SHOULD_not_dispense_drink() {
        // Given
        var nomBoisson = "the";

        when(boissonPort.rechercheBoisson(nomBoisson)).thenReturn(new Boisson(nomBoisson, 2.0));

        // When
        var result = application.commandeBoisson(nomBoisson, true, new PaiementDTO(2.0));

        // Then
        assertThat(result).isEqualTo("Montant insuffisant (Prix : 2.5€)");
    }


}
