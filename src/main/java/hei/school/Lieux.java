package hei.school;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
public class Lieux {
    private String nom;
    private List<Rue> rues;

    @Override
    public String toString() {
        return "Lieux{" +
                "nom='" + nom +
                '}';
    }

    public Lieux(String nom) {
        this.nom = nom;
        this.rues = new ArrayList<>();
    }

    public void ajouterRue(Rue rue) {
        if (!rues.contains(rue)){
            rues.add(rue);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lieux lieux = (Lieux) o;
        return Objects.equals(nom, lieux.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nom);
    }
}