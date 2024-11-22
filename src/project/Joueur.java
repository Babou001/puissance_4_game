package project;


public class Joueur {
    
    private final int numeroJoueur; // Player's number
    private final Jeton jetonJoueur; // Player's token (X or O)
    
    
    public Joueur(int numeroJoueur, Jeton jetonJoueur) {
        this.numeroJoueur = numeroJoueur;
        this.jetonJoueur = jetonJoueur;
    }
    
    
    public boolean placerJeton(int colonne, Grille grille) {
        for (int i = Grille.LIGNES - 1; i >= 0; i--) {
            if (grille.getCelluleByIndex(i, colonne).estVide()) {
                grille.setCelluleByIndex(i, colonne, getJetonJoueur());
                return true; 
            }
        }
        return false;
    }

    
    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    
    public Jeton getJetonJoueur() {
        return jetonJoueur;
    }
}
