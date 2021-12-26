package Simulation.agents;

public class Fish extends LivingCreature {

    private final String name;
    private final String species;
    private final boolean male;
    private final boolean isCarnivorous;

    static final String[] knownSpecies = {"Carpe", "Bar", "Sole", "Thon", "Mérou", "Poisson-clown"};

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isMale() {
        return male;
    }

    public boolean isCarnivorous() {
        return isCarnivorous;
    }

    public Fish(String name, String species, boolean sex, boolean isCarnivorous) {
        this.name = name;
        this.species = species;
        this.male = sex;
        this.isCarnivorous = isCarnivorous;
    }

    public Fish(String name, int species, boolean sex, boolean isCarnivorous) {
        this.name = name;
        this.species = knownSpecies[species];
        this.male = sex;
        this.isCarnivorous = isCarnivorous;
    }

    public Fish(String name, String species, boolean sex, boolean isCarnivorous, int age) {
        this.name = name;
        this.species = species;
        this.male = sex;
        this.isCarnivorous = isCarnivorous;
        this.setAge(age);
    }

    public Fish(String name, int species, boolean sex, boolean isCarnivorous, int age) {
        this.name = name;
        this.species = knownSpecies[species];
        this.male = sex;
        this.isCarnivorous = isCarnivorous;
        this.setAge(age);
    }

    public void eat(LivingCreature livingCreature) {
        livingCreature.getsEaten();
        int bonus = (isCarnivorous) ? 5 : 3;
        this.setLifePoints(bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Fish) {
            return name.equals(((Fish) o).name) && species.equals(((Fish) o).species) && male == ((Fish) o).male && isCarnivorous;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = 53;
        hashCode = hashCode * 53 + name.hashCode();
        hashCode = hashCode * 53 + species.hashCode();
        hashCode = hashCode * 53 + ((male) ? 1 : 0);
        hashCode = hashCode * 53 + ((isCarnivorous) ? 1 : 0);
        return hashCode;
    }

    @Override
    public String toString() {
        String s = this.name;
        s+= " is a " + this.species;
        s+= (male) ? " male " : " female ";
        s+= "aged " + this.getAge();
        s+= " with " + this.getLifePoints() + "HP.";
        return s;
    }

    @Override
    public void spendTime() {
        this.setLifePoints(-1);
        this.advanceAge();
    }

    @Override
    public void getsEaten() {
        this.setLifePoints(-4);
    }

}
