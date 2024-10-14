/**
 * 
 */
package project;

/**
 * 
 */
public class Joueur {
	
	private int numeroJoueur ;
	private Jeton jetonJoueur;
	
	private Joueur(int numeroJoueur, Jeton jetonJoueur) {
        this.numeroJoueur = numeroJoueur;
        this.jetonJoueur = jetonJoueur;
	}
	
	public boolean placerJeton(int colonne, Grille grille) {
		for (int i = Grille.ligne - 1; i >= 0; i--) {
            if (grille.getCelluleByIndex(i, colonne).estVide()) {
                grille.setCelluleByIndex(i, colonne, jetonJoueur);
                return true;
            }
        }
		return (false);
	}
}
