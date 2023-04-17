package dev;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ecrire le nom de la langue : ");
        String langue = scanner.nextLine();
        System.out.println("Envoit de la requete de création de langue...");

        AppMethode appMethode = new AppMethode();
        appMethode.cree_langue(langue);


        // L'utilisation de whil pourrais etre une bonne idée
        System.out.println("Voici le menu, taper 1 pour Afficher la filmographie d’un acteur donné, taper 2 pour afficher le casting d’un film, 3 pour afficher des films sortis entre 2 années données, 4 pour afficher des films communs à 2 acteurs/actrices donnés, 5 pour afficher des acteurs communs à 2 films donnés, 6 pour afficher des films sortis entre 2 années données et qui ont un acteur/actrice donné, 7 pour annuler.");
        int choix = scanner.nextInt();
        // equals ne prend pas les int
        if (choix == 1){
            appMethode.filmographieActeur();
        } else if (choix == 2) {
            appMethode.castingFilm();
        } else if (choix == 3) {
            appMethode.filmsSortisEntre();
        } else if (choix == 4) {
            appMethode.filmsCommuns();
        } else if (choix == 5) {
            appMethode.acteursCommuns();
        } else if (choix == 6) {
            appMethode.filmsCommuns();
            appMethode.acteursCommuns();
        } else if (choix == 7) {
            System.out.println("L'application va se fermé. Toute données non sauvegardé seras supprimé.");
            System.out.println("Fermeture de l'application.");
        } else {
            System.out.println("Le système n'as pas compris votre demande.");
            System.out.println("Fermeture de l'application.");
        }
    }
}
