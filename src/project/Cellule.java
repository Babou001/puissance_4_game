package project;

public class Cellule {
    private Jeton jeton = null;

    public Cellule(Jeton jeton) {
        this.jeton = jeton;
    }

    public boolean estVide() {
        return this.jeton == null;
    }

    public void setJeton(Jeton jeton) {
        this.jeton = jeton;
    }

    public Jeton getJeton() {
        return this.jeton;
    }

    public String afficherJeton() {
        return (this.jeton == Jeton.X) ? "X" : (this.jeton == Jeton.O) ? "O" : " ";
    }

    
}
