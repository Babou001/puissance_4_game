package project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Début de la partie
        // On initialise une nouvelle partie
        Puissance4 jeu = new Puissance4();
        System.out.println("Puissance 4");
        
        // On affiche la grille
        jeu.getGrilleJeu().afficherGrille();
        
        Scanner scanner = new Scanner(System.in);
        
        // Boucle de jeu
        while (true) {
            // 1. Le joueur commence chaque tour par placer un jeton
            System.out.println("Joueur " + jeu.joueurActuel.getNumeroJoueur() + " (" + jeu.joueurActuel.getJetonJoueur() + "), choisissez une colonne (0-6) : ");
            int colonne = scanner.nextInt();
            
            // 2. On vérifie si le jeton a été bien placé
            if (jeu.joueurUnCoup(colonne)) {
                // 2.1. Si non, on affiche la grille
                jeu.getGrilleJeu().afficherGrille();
                
                // 2.2. Si oui, on vérifie si le jeton permet de gagner
                if (jeu.gagner()) {
                    System.out.println("Le joueur " + jeu.joueurActuel.getNumeroJoueur() + " a gagné !");
                    break; // Arrête la boucle en cas de victoire
                }
                
                // 2.2.2. On vérifie si il y a une égalité
                if (jeu.estEgalite()) {
                    System.out.println("Match nul !");
                    break; // Arrête la boucle en cas d'égalité
                }
                
                // 2.2.3. On incrémente le compteur tourActuel (déjà géré par le changement de joueur)
                // 2.2.4. On change le joueur actuel
                jeu.changeJoueurActuel();
            } else {
                // Si la colonne est pleine, on avertit le joueur et demande une autre colonne
                System.out.println("La colonne est pleine, essayez une autre colonne.");
            }
        }
        
        scanner.close(); // Ferme le scanner une fois le jeu terminé
    }
}
