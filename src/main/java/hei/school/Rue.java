package hei.school;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Rue {
    private String  nom;
    private Lieux debut;
    private Lieux arrive;

    public Rue(String nom, Lieux lieu1, Lieux lieu2) {
        this.nom = nom;
        this.debut = lieu1;
        this.arrive = lieu2;

        lieu1.ajouterRue(this);
        lieu2.ajouterRue(this);
    }

    public Rue(String nom) {
        this.nom = nom;
    }

    public Rue(Lieux lieu1, Lieux lieu2) {
        this.debut = lieu1;
        this.arrive = lieu2;

        lieu1.ajouterRue(this);
        lieu2.ajouterRue(this);
    }
}
