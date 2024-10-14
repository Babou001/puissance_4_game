package project;

public class Grille {
    public static final int ligne = 6;
    public static final int colonnes = 7;
    private Cellule[][] plateau = new Cellule[ligne][colonnes];

    public void afficherGrille(){

    }


    public Cellule getCelluleByIndex(int ligne , int colonne){
        return this.plateau[ligne][colonne] ;
    }


    public void setCelluleByIndex(int ligne , int colonne, Jeton jeton){
        Cellule cellule = this.plateau[ligne][colonne];
        cellule.set_jeton(jeton);
    }


	public boolean estRemplie() {
		// TODO Auto-generated method stub
		return false;
	}



}
