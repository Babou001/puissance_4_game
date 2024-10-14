/**
 * 
 */
package project;

/**
 * 
 */
public class Puissance4 {

	private int tour;

	private final Grille grilleJeu = new Grille();
	
	private final Joueur joueur1 = new Joueur(0, Jeton.X);
	
	private final Joueur joueur2 = new Joueur(1, Jeton.O);
		
	private Joueur joueurActuel;
	
	public void changeJoueurActuel() {
		joueurActuel = (joueurActuel == joueur1) ? joueur2 : joueur1;
	}
	
	public boolean joueurUnCoup(int colonnes) {
		if (joueurActuel.placerJeton(colonnes, grilleJeu)) {
			if (gagner()) {
	            System.out.println("Le joueur " + joueurActuel.getNumeroJoueur() + " a gagné !");
	        } else if (estEgalite()) {
	            System.out.println("Match nul !");
	        }
	        changeJoueurActuel();
	        return true;
		}
		return false;
	}
	
	public boolean gagnerHorizontal() {
		for (int i = 0; i < Grille.ligne; i++) {
            int count = 0;
            for (int j = 0; j < Grille.colonnes; j++) {
                if (grilleJeu.getCelluleByIndex(i, j).afficherJeton().equals(joueurActuel.getJetonJoueur().toString())) {
                    count++;
                    if (count == 4) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;
        
	}
	
	public boolean gagnerVertical() {
		for (int j = 0; j < Grille.colonnes; j++) {
            int count = 0;
            for (int i = 0; i < Grille.ligne; i++) {
                if (grilleJeu.getCelluleByIndex(i, j).afficherJeton().equals(joueurActuel.getJetonJoueur().toString())) {
                    count++;
                    if (count == 4) return true;
                } else {
                    count = 0;
                }
            }
        }
        return false;	
        
	}
	
	public boolean gagnerDiagonal() {
		for (int i = 0; i < Grille.ligne - 3; i++) {
            for (int j = 0; j < Grille.colonnes - 3; j++) {
                if (grilleJeu.getCelluleByIndex(i, j).afficherJeton().equals(joueurActuel.getJetonJoueur().toString()) &&
                    grilleJeu.getCelluleByIndex(i + 1, j + 1).afficherJeton().equals(joueurActuel.getJetonJoueur().toString()) &&
                    grilleJeu.getCelluleByIndex(i + 2, j + 2).afficherJeton().equals(joueurActuel.getJetonJoueur().toString()) &&
                    grilleJeu.getCelluleByIndex(i + 3, j + 3).afficherJeton().equals(joueurActuel.getJetonJoueur().toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean gagnerDiagonalInverse() {
        for (int i = 3; i < Grille.ligne; i++) {
            for (int j = 0; j < Grille.colonnes - 3; j++) {
                if (grilleJeu.getCelluleByIndex(i, j).afficherJeton().equals(joueurActuel.getJetonJoueur().toString()) &&
                    grilleJeu.getCelluleByIndex(i - 1, j + 1).afficherJeton().equals(joueurActuel.getJetonJoueur().toString()) &&
                    grilleJeu.getCelluleByIndex(i - 2, j + 2).afficherJeton().equals(joueurActuel.getJetonJoueur().toString()) &&
                    grilleJeu.getCelluleByIndex(i - 3, j + 3).afficherJeton().equals(joueurActuel.getJetonJoueur().toString())) {
                    return true;
                }
            }
        }
        return false;
        
    }
	
	public boolean gagner() {
		return gagnerHorizontal() || gagnerVertical() || gagnerDiagonal() || gagnerDiagonalInverse();
	}

	public boolean estEgalite() {
	     return grilleJeu.estRemplie() && !gagner();
    }	
}
