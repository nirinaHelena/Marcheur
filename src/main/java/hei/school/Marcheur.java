package hei.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class Marcheur {
    private String nom;
    private Lieux depart;
    private Lieux destination;
    private Carte carte;


    public Marche trajet(Marcheur marcheur){
        List<Lieux> lieuxVisite = new ArrayList<>();
        lieuxVisite.add(marcheur.depart);
        while (!lieuxVisite.contains(marcheur.destination)){
            Lieux lieuxActuel = lieuxVisite.get(lieuxVisite.size() - 1);

            List<Rue> ruesExistant = new ArrayList<>();
            for (Lieux lieux : marcheur.getCarte().getLieux()) {
                ruesExistant.addAll(lieux.getRues());
            }
            // prendre les chemins possible
            List<Lieux> cheminPossible = new ArrayList<>();
            for (Rue rue : ruesExistant) {
                if (rue.getDebut() == lieuxActuel) {
                    cheminPossible.add(rue.getArrive());
                }if (rue.getArrive() == lieuxActuel){
                    cheminPossible.add(rue.getDebut());
                }
            }
            Random random = new Random();
            lieuxVisite.add(cheminPossible.get(random.nextInt(cheminPossible.size())));
            if (lieuxActuel.getRues().get(0).equals(lieuxActuel.getRues().get(lieuxVisite.size() - 1))) {
                marcheur.getCarte().getLieux().remove(lieuxActuel);
            }
        }
        System.out.println(lieuxVisite);
        return new Marche(lieuxVisite);
    }
}
