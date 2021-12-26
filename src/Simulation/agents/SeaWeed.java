package Simulation.agents;

import java.util.UUID;

public class SeaWeed extends LivingCreature {

    private final UUID id;

    public SeaWeed(){
        this.id = UUID.randomUUID();
    }
    public SeaWeed(int lifePoints){
        this.id = UUID.randomUUID();
        this.setLifePoints(-10 + lifePoints);
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof SeaWeed) {
            return id.equals(((SeaWeed) o).id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public void spendTime() {
        this.setLifePoints(1);
        this.advanceAge();
    }

    public int split(){
        if (this.getLifePoints() >= 10) {
            int newHP = this.getLifePoints()/2;
            this.setLifePoints(-newHP);
            return newHP;
        }
        return 0;
    }

    @Override
    public void getsEaten() {
        this.setLifePoints(-2);
    }
}
