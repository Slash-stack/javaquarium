package Tests;

import Simulation.Aquarium;

public class TestAquarium {

    static final String[] noms = {"Némo", "Néo", "Arthur", "Rocky", "Mickey", "Matthew", "Foggy", "Karen", "Carl", "Tom", "Ben", "Ferguson"};

    public static void main(String[] args) {
        Aquarium aqua = new Aquarium();
        for (int i = 0; i<12; i++) {
            aqua.ajouterAlgue();
            aqua.ajouterPoisson(noms[i], i%2 == 1, i%6);
        }
        System.out.println(aqua);
        aqua.passerTemps();
        System.out.println(aqua);
    }


}
