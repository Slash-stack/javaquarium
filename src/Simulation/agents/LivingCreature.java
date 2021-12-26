package Simulation.agents;

public abstract class LivingCreature {

    private int lifePoints = 10;
    private int age = 0;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void advanceAge() {
        this.age++;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = this.lifePoints + lifePoints;
    }

    public abstract void spendTime();

    public abstract void getsEaten();
}
