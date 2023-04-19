package dev;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ecrire le nom de la langue : ");
        String langue = scanner.nextLine();
        System.out.println("Envoit de la requete de création de langue...");

        AppMethode appMethode = new AppMethode();
        System.out.println("appMethode crée");
        appMethode.cree_langue(langue);
        System.out.println("Langue crée");

        // L'utilisation de whil pourrais etre une bonne idée
        System.out.println("Voici le menu, taper 1 pour Afficher la filmographie d’un acteur donné, taper 2 pour afficher le casting d’un film, 3 pour afficher des films sortis entre 2 années données, 4 pour afficher des films communs à 2 acteurs/actrices donnés, 5 pour afficher des acteurs communs à 2 films donnés, 6 pour afficher des films sortis entre 2 années données et qui ont un acteur/actrice donné, 7 pour annuler.");
        int choix = scanner.nextInt();
        // equals ne prend pas les int
        if (choix == 1){
            System.out.println("Entrer le prénom de l'acteur.");
            String prenom = scanner.nextLine();
            System.out.println("Entrer le nom de l'acteur.");
            String nom = scanner.nextLine();
            appMethode.filmographieActeur(prenom, nom);

        } else if (choix == 2) {
            System.out.println("Entrer le nom du filme.");
            String filme = scanner.nextLine();
            appMethode.castingFilm(filme);

        } else if (choix == 3) {
            System.out.println("Entrer l'année de sortie minimal.");
            int annee1 = scanner.nextInt();
            System.out.println("Entrer l'année de sortie maximal.");
            int annee2 = scanner.nextInt();
            appMethode.filmsSortisEntre(annee1, annee2);

        } else if (choix == 4) {
            System.out.println("Entrer le prénom de l'acteur.");
            String prenom1 = scanner.nextLine();
            System.out.println("Entrer le nom de l'acteur.");
            String nom1 = scanner.nextLine();
            System.out.println("Entrer le prénom de l'acteur.");
            String prenom2 = scanner.nextLine();
            System.out.println("Entrer le nom de l'acteur.");
            String nom2 = scanner.nextLine();
            appMethode.filmsCommuns(prenom1, nom1, prenom2, nom2);

        } else if (choix == 5) {
            System.out.println("Entrer le nom du premier filmes.");
            String filmes1 = scanner.nextLine();
            System.out.println("Entrer le nom du second filmes.");
            String filmes2 = scanner.nextLine();
            appMethode.acteursCommuns(filmes1, filmes2);

        } else if (choix == 6) {
            System.out.println("Entrer le prénom de l'acteur.");
            String prenom1 = scanner.nextLine();
            System.out.println("Entrer le nom de l'acteur.");
            String nom1 = scanner.nextLine();
            System.out.println("Entrer le prénom de l'acteur.");
            String prenom2 = scanner.nextLine();
            System.out.println("Entrer le nom de l'acteur.");
            String nom2 = scanner.nextLine();
            appMethode.filmsCommuns(prenom1, nom1, prenom2, nom2);

            System.out.println("Entrer le nom du premier filmes.");
            String filmes1 = scanner.nextLine();
            System.out.println("Entrer le nom du second filmes.");
            String filmes2 = scanner.nextLine();
            appMethode.acteursCommuns(filmes1, filmes2);

        } else if (choix == 7) {
            System.out.println("L'application va se fermé. Toute données non sauvegardé seras supprimé.");
            System.out.println("Fermeture de l'application.");

        } else {
            System.out.println("Le système n'as pas compris votre demande.");
            System.out.println("Fermeture de l'application.");
        }
    }
}
