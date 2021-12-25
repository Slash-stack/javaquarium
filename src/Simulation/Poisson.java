package Simulation;

public class Poisson extends EtreVivant{

    private String nom;
    private String espece;
    private boolean sexe; // true = mâle && false = femelle
    private boolean estCarnivore;

    static final String[] especes = {"Carpe", "Bar", "Sole", "Thon", "Mérou", "Poisson-clown"};

    public String getNom() {
        return nom;
    }

    public Poisson(String nom, boolean sexe, int espece) {
        this.nom = nom;
        this.sexe = sexe;
        if (espece < 3) { this.estCarnivore = false; }
        else {this.estCarnivore = true;}
        this.espece = especes[espece];
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Poisson) {
            if (this.nom.equals(((Poisson) o).nom) && this.espece.equals(((Poisson) o).espece) && this.sexe == ((Poisson) o).sexe) return true;
        }
        return false;
    }

    public int manger(Poisson p){
        if (this.estCarnivore) { return 1;}
        return 0;
    }

    @Override
    public String toString() {
        String s = this.nom + " est un";
        if (this.espece.equals(especes[0])) {
            s+= "e " + this.espece;
        } else { s+= " " + this.espece; }
        if (this.sexe) {
            s+= " mâle.";
            return s;
        }
        s+= " femelle.";
        return s;
    }
}
