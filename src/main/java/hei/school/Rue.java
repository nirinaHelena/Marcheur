package hei.school;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Rue {
    private String  nom;
    private final Lieux debut;
    private final Lieux arrive;

    public Rue(Lieux lieux1, Lieux lieux2) {
        this.debut = lieux1;
        this.arrive = lieux2;
    }
}
