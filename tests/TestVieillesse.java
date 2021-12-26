import Simulation.enivronnement.Aquarium;

public class TestVieillesse {

    static final String[] names = {"Némo", "Néo", "Arthur", "Rocky", "Mickey", "Matthew", "Foggy", "Karen", "Carl", "Tom", "Ben", "Ferguson"};

    public static void main(String[] args) {
        Aquarium aqua = new Aquarium();

        for (int i = 0; i < 12; i++) {
            aqua.addFish(names[i], i%6, aqua.getR().nextInt(2) == 1, i >= 3);
            aqua.addSeaWeed();
        }
        System.out.println(aqua);
        for (int i = 0; i < 21; i++){
            aqua.spendTime();
        }
        System.out.println(aqua);
    }
}
