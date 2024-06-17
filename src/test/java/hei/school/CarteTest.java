package hei.school;

import junit.framework.TestCase;

import java.util.List;

public class CarteTest extends TestCase {

    public void testTrajet() {
        Lieux marais = new Lieux("marais");
        Lieux sekolintsika = new Lieux("sekolintsika");
        Rue rue1 = new Rue(marais, sekolintsika);
        Lieux hei = new Lieux("hei");
        Rue rue2 = new Rue(sekolintsika, hei);
        Lieux pullman = new Lieux("pullman");
        Rue rue3 = new Rue("Rue Andriantsihorana", hei, pullman);
        Lieux nexta = new Lieux("nexta");
        Rue rue4 = new Rue(pullman, nexta);
        Lieux balancoire = new Lieux("balancoire");
        Rue rue5 = new Rue("Rue Ranaivo", pullman, balancoire);
        Lieux esti = new Lieux("esti");
        Rue rue6 = new Rue(balancoire, esti);
        Lieux boulevardDeLEurope = new Lieux("boulevardDeLEurope");
        Rue rue7 = new Rue(balancoire, boulevardDeLEurope);
        Rue rue8 = new Rue(boulevardDeLEurope, esti);
        Rue rue9 = new Rue(hei, balancoire);
        Carte carte = new Carte(List.of(
                rue1, rue2, rue3, rue4,
                rue5, rue6, rue7,
                rue8, rue9));

        Marche marche = carte.trajet(hei, esti, carte);
        Lieux arrive = marche.getLieux().get(marche.getLieux().size() - 1);
        assertEquals(esti, arrive);
        Lieux depart = marche.getLieux().get(0);
        assertEquals(hei, depart);
    }
}