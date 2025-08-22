package dev.kata.hexa.hexagonal.coffee.primary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MachineACafePortControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ResultActions call_machine(String boisson, String montant) throws Exception {
        return mockMvc.perform(post("/hexa/cafe/commande")
                .param("boisson", boisson)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"amount\":" + montant + " }")
        );
    }

    @Test
    void commande_valide_retourne_confirmation() throws Exception {
        call_machine("expresso", "2.0")
            .andExpect(status().isOk())
            .andExpect(content().string("Voici votre Expresso"));
    }

    @Test
    void boisson_inconnue_retourne_message_erreur() throws Exception {
        call_machine("biere", "2.0")
            .andExpect(status().isOk())
            .andExpect(content().string("Boisson inconnue."));
    }

    @Test
    void montant_insuffisant_retourne_message_erreur() throws Exception {
        call_machine("cappuccino", "0.5")
            .andExpect(status().isOk())
            .andExpect(content().string(org.hamcrest.Matchers.containsString("Montant insuffisant")));
    }

}