package org.cours.springdatarest;

import org.cours.modele.VoitureRepo;
import org.cours.web.VoitureController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDataRestApplicationTests {

    @Autowired
    private VoitureController voitureController;

    @Autowired
    private VoitureRepo voitureRepo;

    @Test
    void contextLoads() {
        // Vérifie que le contexte Spring se charge correctement
        assertThat(voitureController).isNotNull();
    }

    @Test
    void repositoryIsLoaded() {
        // Vérifie que le repository est injecté
        assertThat(voitureRepo).isNotNull();
    }

    @Test
    void applicationStartsSuccessfully() {
        // Test que l'application démarre sans erreur
        SpringDataRestApplication.main(new String[] {});
    }
}