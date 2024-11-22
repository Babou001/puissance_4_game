package project;

public class Grille {
    public static final int LIGNES = 6;
    public static final int COLONNES = 7;
    private Cellule[][] plateau = new Cellule[LIGNES][COLONNES];

    public Grille() {
        // Initialize all cells with empty tokens
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                plateau[i][j] = new Cellule(null); // null means the cell is empty
            }
        }
    }

    public void afficherGrille() {
        StringBuilder tableauStr = new StringBuilder();

        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                tableauStr.append(plateau[i][j].afficherJeton());
                if (j == COLONNES - 1) {
                    tableauStr.append('\n');
                }
            }
        }

        System.out.print(tableauStr.toString());
    }

    public Cellule getCelluleByIndex(int ligne, int colonne) {
        return this.plateau[ligne][colonne];
    }

    public void setCelluleByIndex(int ligne, int colonne, Jeton jeton) {
        Cellule cellule = this.plateau[ligne][colonne];
        cellule.setJeton(jeton);  // Fix typo: set_jeton to setJeton
    }

    public boolean estRemplie() {
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                if (plateau[i][j].estVide()) {
                    return false;  // If any cell is empty, the grid is not full
                }
            }
        }
        return true;  // All cells are filled
    }
}
