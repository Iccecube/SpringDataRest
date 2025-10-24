package org.cours.springdatarest;

import org.cours.modele.Proprietaire;
import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class VoitureRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private VoitureRepo voitureRepo;

    @Test
    public void ajouterVoiture() {
        // Given - Créez et persistez d'abord le propriétaire
        Proprietaire proprietaire1 = new Proprietaire("John", "Doe");
        Proprietaire savedProprietaire = entityManager.persistAndFlush(proprietaire1);

        // Then - Créez la voiture avec le propriétaire persisté
        Voiture voiture = new Voiture("MiolaCar", "Uber", "Blanche", "M-2020", 2021, 180000, savedProprietaire);

        // When - Persistez la voiture
        Voiture savedVoiture = entityManager.persistAndFlush(voiture);

        // Then - Vérifiez
        assertThat(savedVoiture.getId()).isNotNull();
        assertThat(savedVoiture.getMarque()).isEqualTo("MiolaCar");
    }

    @Test
    public void supprimerVoiture() {
        // Given - Créez et persistez d'abord le propriétaire
        Proprietaire proprietaire1 = new Proprietaire("John", "Doe");
        Proprietaire savedProprietaire = entityManager.persistAndFlush(proprietaire1);

        // Persistez les voitures
        entityManager.persistAndFlush(new Voiture("MiolaCar", "Uber", "Blanche", "M-2020", 2021, 180000, savedProprietaire));
        entityManager.persistAndFlush(new Voiture("MiniCooper", "Uber", "Rouge", "C-2020", 2021, 180000, savedProprietaire));

        // When - Supprimez toutes les voitures
        voitureRepo.deleteAll();

        // Then - Vérifiez que la base est vide
        assertThat(voitureRepo.findAll()).isEmpty();
    }
}