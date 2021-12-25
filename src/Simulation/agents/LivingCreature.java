package Simulation.agents;

public abstract class LivingCreature {

    private int lifePoints = 10;

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = this.lifePoints + lifePoints;
    }

    public abstract void spendTime();

    public abstract void getsEaten();
}
