package hei.school;

import junit.framework.TestCase;

import java.util.List;

public class CarteTest extends TestCase {

    public void testTrajet() {
        Lieux marais = new Lieux("marais");
        Lieux sekolintsika = new Lieux("sekolintsika");
        Lieux hei = new Lieux("hei");
        Lieux pullman = new Lieux("pullman");
        Lieux nexta = new Lieux("nexta");
        Lieux balancoire = new Lieux("balancoire");
        Lieux esti = new Lieux("esti");
        Lieux boulevardDeLEurope = new Lieux("boulevardDeLEurope");

        Rue rue1 = new Rue(marais, sekolintsika);
        Rue rue2 = new Rue(sekolintsika, hei);
        Rue rue3 = new Rue("Rue Andriantsihorana", hei, pullman);
        Rue rue4 = new Rue(hei, balancoire);
        Rue rue5 = new Rue("Rue Ranaivo", pullman, balancoire);
        Rue rue6 = new Rue(pullman, nexta);
        Rue rue7 = new Rue(balancoire, esti);
        Rue rue9 = new Rue(boulevardDeLEurope, esti);
        Rue rue8 = new Rue(balancoire, boulevardDeLEurope);

        Carte carte = new Carte(List.of(marais, sekolintsika, hei, pullman, nexta, balancoire, boulevardDeLEurope, esti));

        Marcheur marcheur = new Marcheur("bjani", hei, esti, carte);
        Marche marche = marcheur.trajet(marcheur);
        Lieux arrive = marche.getLieux().get(marche.getLieux().size() - 1);
        assertEquals(esti, arrive);
        Lieux depart = marche.getLieux().get(0);
        assertEquals(hei, depart);
        assertTrue(marche.getLieux().contains(balancoire));
    }
}