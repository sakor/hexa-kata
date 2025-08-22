package dev.kata.hexa.couche;

import dev.kata.hexa.couche.bean.Boisson;
import dev.kata.hexa.couche.bean.Payment;
import dev.kata.hexa.couche.dao.BoissonDAO;
import dev.kata.hexa.couche.message.MessagerEnCouche;
import dev.kata.hexa.couche.service.CoffeeMachineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CoffeMachineServiceTest {

    @Mock
    private BoissonDAO boissonDAO;

    @Mock
    private MessagerEnCouche messager;

    @InjectMocks
    private CoffeeMachineService service;

    @Test
    void orderDrink_WITH_the_no_sugar_and_2_euros_SHOULD_dispense_drink() {
        // Given
        var nomBoisson = "the";
        var montant = 2.0;
        when(boissonDAO.findByName(nomBoisson)).thenReturn(new Boisson(nomBoisson, montant));

        // When
        var result = service.orderDrink(nomBoisson, false ,new Payment(2.0));

        // Then
        assertThat(result).isEqualTo("Voici votre " + nomBoisson);
        verify(messager, times(1)).envoyer(nomBoisson);

    }

    @Test
    void orderDrink_WITH_the_no_sugar_and_1_euros_SHOULD_not_dispense_drink() {
        // Given
        var nomBoisson = "the";
        var montant = 2.0;
        when(boissonDAO.findByName(nomBoisson)).thenReturn(new Boisson(nomBoisson, montant));

        // When
        var result = service.orderDrink(nomBoisson, false, new Payment(1.0));

        // Then
        assertThat(result).isEqualTo("Montant insuffisant (Prix : " + montant + "€)");
        verify(messager, times(1)).envoyer(nomBoisson);

    }

    @Test
    void orderDrink_WITH_unknow_no_sugar_and_2_euros_SHOULD_send_bad_drink_message() {
        // Given
        var nomBoisson = "unknow";
        when(boissonDAO.findByName(nomBoisson)).thenReturn(null);

        // When
        var result = service.orderDrink(nomBoisson, false, new Payment(2.0));

        // Then
        assertThat(result).isEqualTo("Boisson inconnue.");
        verify(messager, times(1)).envoyer(nomBoisson);

    }

    @Test
    void orderDrink_WITH_the_with_sugar_and_2_euros_SHOULD_not_dispense_drink() {
        // Given
        var nomBoisson = "the";

        when(boissonDAO.findByName(nomBoisson)).thenReturn(new Boisson(nomBoisson, 2.0));

        // When
        var result = service.orderDrink(nomBoisson, true, new Payment(2.0));

        // Then
        assertThat(result).isEqualTo("Montant insuffisant (Prix : 2.5€)");
        verify(messager, times(1)).envoyer(nomBoisson);

    }


}
