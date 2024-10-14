package src.project;

public class Grille {
    public int ligne = 6;
    public int colonnes = 7;
    private Cellule[][] plateau;

    public void afficherGrille(){

    }


    public Cellule getCelluleByIndex(int ligne , int colonne){
        return this.plateau[ligne][colonne] ;
    }


    public void setCelluleByIndex(int ligne , int colonne, project.Jeton jeton){
        Cellule cellule = this.plateau[ligne][colonne];
        cellule.set_jeton(jeton);

    }

}
