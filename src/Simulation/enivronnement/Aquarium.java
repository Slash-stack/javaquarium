package Simulation.enivronnement;

import Simulation.agents.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Aquarium {

    private final HashSet<SeaWeed> seaWeedSet;
    private final HashSet<Fish> fishSet;
    private int round = 0;
    private final Random r;

    public int getRound() {
        return round;
    }

    public Random getR() {
        return r;
    }

    public Aquarium() {
        this.fishSet = new HashSet<>();
        this.seaWeedSet = new HashSet<>();
        r = new Random();
    }

    public void addFish(String name, String species, boolean sex, boolean isCarnivorous){
        fishSet.add(new Fish(name, species, sex, isCarnivorous));
    }

    public void addFish(String name, int species, boolean sex, boolean isCarnivorous){
        fishSet.add(new Fish(name, species, sex, isCarnivorous));
    }

    public void addSeaWeed(){
        seaWeedSet.add(new SeaWeed());
    }

    public Fish selectRandomFish(){
        int indexFood = r.nextInt(fishSet.size());

        int i = 0;
        for(Fish fish : fishSet) {
            if (i == indexFood) {
                return fish;
            }
            i++;
        }
        return null;
    }

    public SeaWeed selectRandomSeaWeed(){
        int indexFood = r.nextInt(seaWeedSet.size());

        int i = 0;
        for(SeaWeed seaWeed : seaWeedSet) {
            if (i == indexFood) {
                return seaWeed;
            }
            i++;
        }
        return null;
    }

    public void spendTime() {
        round++;
        ArrayList<SeaWeed> eatenSeaWeed = new ArrayList<>();
        ArrayList<Fish> eatenFish = new ArrayList<>();
        // update life points
        for (Fish f : fishSet) {
            f.spendTime();
        }
        for (SeaWeed s : seaWeedSet) {
            s.spendTime();
        }

        Iterator<Fish> iterFish = fishSet.iterator();
        while (iterFish.hasNext()) {
            Fish fish = iterFish.next();
            // the fish needs to eat
            if (fish.getLifePoints() <= 5) {
                if (fish.isCarnivorous()) {
                    Fish food = selectRandomFish();
                    if (!fish.equals(food) || !eatenFish.contains(food)) {
                        fish.eat(food);
                        if (food.getLifePoints() <= 0) eatenFish.add(food);
                    }
                } else {
                    SeaWeed food = selectRandomSeaWeed();
                    if (!eatenSeaWeed.contains(food)) {
                        fish.eat(food);
                        if (food.getLifePoints() <= 0) eatenSeaWeed.add(food);
                    }
                }
            }
        }
        fishSet.removeAll(eatenFish);
        seaWeedSet.removeAll(eatenSeaWeed);
    }

    @Override
    public String toString() {
        String s = "The aquarium contains ";
        s+= seaWeedSet.size();
        s+= " sea weeds and the following fishs :\n";
        for (Fish f : fishSet) {
            s+= "\t\t" + f + "\n";
        }
        return s;
    }

}
