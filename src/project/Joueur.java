/**
 * 
 */
package project;

/**
 * 
 */
public class Joueur {
	
	private final int numeroJoueur ;
	private final Jeton jetonJoueur;
	
	public Joueur(int numeroJoueur, Jeton jetonJoueur) {
        this.numeroJoueur = numeroJoueur;
        this.jetonJoueur = jetonJoueur;
	}
	
	public boolean placerJeton(int colonne, Grille grille) {
		for (int i = Grille.ligne - 1; i >= 0; i--) {
            if (grille.getCelluleByIndex(i, colonne).estVide()) {
                grille.setCelluleByIndex(i, colonne, getJetonJoueur());
                return true;
            }
        }
		return (false);
	}

	public int getNumeroJoueur() {
		return numeroJoueur;
	}

	/**
	 * @return the jetonJoueur
	 */
	public Jeton getJetonJoueur() {
		return jetonJoueur;
	}
}
