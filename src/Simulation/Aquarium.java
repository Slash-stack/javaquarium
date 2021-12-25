package Simulation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Aquarium {

    private ArrayList<Algue> listeAlgues;
    private ArrayList<Poisson> listePoissons;
    private Random r;

    public Aquarium(){
        listePoissons = new ArrayList<Poisson>();
        listeAlgues = new ArrayList<Algue>();
        r = new Random();
    }

    public void ajouterPoisson(String nom, boolean sexe, int espece){
        Poisson nvPoisson = new Poisson(nom, sexe, espece);
        listePoissons.add(nvPoisson);
    }

    public void ajouterAlgue() {
        Algue nvAlgue = new Algue();
        listeAlgues.add(nvAlgue);
    }

    public void passerTemps(){
        ArrayList<Poisson> eatenFish = new ArrayList<>();
        ArrayList<Algue> eatenAlgue = new ArrayList<>();
        Iterator<Poisson> iterPoisson = listePoissons.iterator();
        while (iterPoisson.hasNext()) {
            Poisson poisson = iterPoisson.next();
            // Si le poisson n'a pas été mangé
            if (!eatenFish.contains(poisson)){
                int indexPoisson = r.nextInt(listePoissons.size());
                Poisson aManger = listePoissons.get(indexPoisson);
                while (poisson.equals(aManger) || eatenFish.contains(aManger)) {
                    indexPoisson = r.nextInt(listePoissons.size());
                    aManger = listePoissons.get(indexPoisson);
                }
                if (poisson.manger(aManger) == 1){
                    eatenFish.add(aManger);
                    System.out.println(poisson.getNom() + " a mangé " + aManger.getNom());
                }
                eatenAlgue.add(listeAlgues.get(r.nextInt(listeAlgues.size())));
            }
        }
        listePoissons.removeAll(eatenFish);
        listeAlgues.removeAll(eatenAlgue);
    }

    @Override
    public String toString() {
        String s = "L'aquarium contient ";
        s += listeAlgues.size();
        s += " algues et les poissons suivants :\n";
        for (Poisson p : listePoissons) {
            s += "\t\t" + p.toString() + "\n";
        }
        return s;
    }
}
