package project;

public class Puissance4 {

    private int tour;
    private final Grille grilleJeu = new Grille();
    private final Joueur joueur1 = new Joueur(0, Jeton.X);
    private final Joueur joueur2 = new Joueur(1, Jeton.O);
    public Joueur joueurActuel;

    public Puissance4() {
        // Initial player is joueur1 (could alternate depending on your game's flow)
        this.joueurActuel = joueur1;
    }

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
            //changeJoueurActuel();
            return true;
        }
        return false;
    }

    // Generic method to check consecutive tokens in a direction
    private boolean checkDirection(int startRow, int startCol, int deltaRow, int deltaCol) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int row = startRow + i * deltaRow;
            int col = startCol + i * deltaCol;
            if (row >= 0 && row < Grille.LIGNES && col >= 0 && col < Grille.COLONNES &&
                grilleJeu.getCelluleByIndex(row, col).getJeton() == joueurActuel.getJetonJoueur()) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;
    }

    public boolean gagnerHorizontal() {
        for (int i = 0; i < Grille.LIGNES; i++) {
            for (int j = 0; j < Grille.COLONNES - 3; j++) {
                if (checkDirection(i, j, 0, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean gagnerVertical() {
        for (int j = 0; j < Grille.COLONNES; j++) {
            for (int i = 0; i < Grille.LIGNES - 3; i++) {
                if (checkDirection(i, j, 1, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean gagnerDiagonal() {
        for (int i = 0; i < Grille.LIGNES - 3; i++) {
            for (int j = 0; j < Grille.COLONNES - 3; j++) {
                if (checkDirection(i, j, 1, 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean gagnerDiagonalInverse() {
        for (int i = 3; i < Grille.LIGNES; i++) {
            for (int j = 0; j < Grille.COLONNES - 3; j++) {
                if (checkDirection(i, j, -1, 1)) {
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

    public Grille getGrilleJeu() {
        return grilleJeu;
    }


    
}
