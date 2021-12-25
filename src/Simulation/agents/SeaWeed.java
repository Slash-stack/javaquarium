package Simulation.agents;

import java.util.UUID;

public class SeaWeed extends LivingCreature {

    private final UUID id;

    public SeaWeed(){
        this.id = UUID.randomUUID();
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
    }

    @Override
    public void getsEaten() {
        this.setLifePoints(-2);
    }
}
