package hei.school;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Data
public class Carte {
    private final List<Rue> rues;

    public Marche trajet(Lieux depart, Lieux arrive, Carte carte){
        List<Lieux> lieuxVisite = new ArrayList<>();
        lieuxVisite.add(depart);
        while (!lieuxVisite.contains(arrive)){
            Lieux lieuxActuel = lieuxVisite.get(lieuxVisite.size() - 1);

            // prendre les chemins possible
            List<Lieux> cheminPossible = new ArrayList<>();
            for (Rue rue : carte.getRues()) {
                if (rue.getDebut() == lieuxActuel) {
                    cheminPossible.add(rue.getArrive());
                }if (rue.getArrive() == lieuxActuel){
                    cheminPossible.add(rue.getDebut());
                }
            }
            Random random = new Random();
            lieuxVisite.add(cheminPossible.get(random.nextInt(cheminPossible.size())));
        }
        return new Marche(lieuxVisite);
    }
}
