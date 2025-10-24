package org.cours.web;

import org.cours.modele.Voiture;
import org.cours.modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/voitures")
public class VoitureController {

    @Autowired
    private VoitureRepo voitureRepo;


    @GetMapping
    public Iterable<Voiture> getVoitures() {
        return voitureRepo.findAll();
    }


    @PostMapping
    public Voiture addVoiture(@RequestBody Voiture voiture) {
        return voitureRepo.save(voiture);
    }


    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureRepo.deleteById(id);
    }


    @PutMapping("/{id}")
    public Voiture updateVoiture(@PathVariable Long id, @RequestBody Voiture voitureDetails) {
        Voiture voiture = voitureRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Voiture non trouvée avec l'id: " + id));

        voiture.setMarque(voitureDetails.getMarque());
        voiture.setModele(voitureDetails.getModele());
        voiture.setCouleur(voitureDetails.getCouleur());
        voiture.setImmatricule(voitureDetails.getImmatricule());
        voiture.setAnnee(voitureDetails.getAnnee());
        voiture.setPrix(voitureDetails.getPrix());

        return voitureRepo.save(voiture);
    }
}