package project;


public class Cellule {
    private Jeton jeton = null;

    public Cellule(Jeton jeton) {
        this.jeton = jeton;
    }

    public boolean estVide(){

        if (this.jeton == null)
            return true;
        else
            return false;

    }

    public void set_jeton(Jeton jeton){
        this.jeton = jeton;
    }

    public String afficherJeton(){
    	if(this.jeton == Jeton.X) {
    		return "X";
    	} else if (this.jeton == Jeton.O){
    		return "O";
    	}else {
    		return " ";
    		
    	}
    }
}
