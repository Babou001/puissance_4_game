/**
 * 
 */
package project;

/**
 * 
 */
public class Puissance4 {

	private int tour;

	private Grille grilleJeu;
	
	private Joueur joueur1;
	
	private Joueur joueur2;
		
	private Joueur joueurActuel;
	
	public void changeJoueurActuel() {
		
	}
	
	public boolean joueurUnCoup(int colonnes) {
		if (joueurActuel.placerJeton(colonnes, grilleJeu)) {
            changeJoueurActuel();
		}
		return false;
	}
	
	public boolean gagnerHorizontal() {
		return false;
	}
	
	public boolean gagnerVertical() {
		return false;
	}
	
	public boolean gagnerDiagonalInverse() {
		return false;
	}
	
	public boolean gagner() {
		return gagnerHorizontal() || gagnerVertical() || gagnerDiagonalInverse();
	}
	
	public boolean estEgalite() {
	     return grilleJeu.estRemplie() && !gagner();
    }	
}
