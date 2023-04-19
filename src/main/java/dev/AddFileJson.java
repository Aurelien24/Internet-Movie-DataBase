package dev;


import dev.domain.Acteur;
import dev.domain.Adresse;
import dev.domain.Langue;
import dev.domain.Personne;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;
import static java.lang.Character.highSurrogate;


public class AddFileJson {
    public static void main(String[] args) throws IOException {

        File file = new File("test.json");
        Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        String line;

        // FAIRE UN FILME :
        String derniereLigne = null;

        boolean newFilm = true;
        String idFilm = null;

        boolean newPays = false;
        String paysFilm = "null";
        String urlPaysFilm = null;

        String nomFilm = null;
        String urlFilm = null;
        String descFilm = null;
        String langueFilm = null;

        boolean newLieuTournage = false;
        String villeTournage = null;
        String etasTournage = null;
        String paysTournage = null;

        boolean newRealisateur = false;
        String nomRealisateur = null;
        String prenomRealisateur = null;
        String urlRealisateur = null;

        boolean newActeur = false;
        String idActeur = null;
        String nomActeur = null;
        String prenomActeur = null;

        Date dateNaissanceActeur = new Date();
        String villeNaissanceActeur = null;
        String regionNaissanceActeur = null;
        String paysNaissanceActeur = null;
        String urlActeur = null;
        String heightActeur = null;

        String anneeSortieFilm = null;

        boolean newRole = false;
        String roleNom = null;
        // Ce sont des acteur qui sont dans role après

        String[] genreFilm = null;

        // Ajout de jsonMethode pour avoir mes méthodes
        JsonMethode jsonMethode = new JsonMethode();

        while ((line = br.readLine()) != null) {

            // String idFilm = "null";
            if(line.contains("id :") && newFilm){
                int max = line.length() -1;
                idFilm = line.substring(7, max);
                newFilm = false;
                System.out.println(idFilm);
            }

            // début d'objet pays
            if (line.contains("pays : {")){
                newPays = true;
            }

            // String paysFilm = "null";
            if (line.contains("nom :") && derniereLigne.contains("pays : {")){
                int max = line.length() -1;
                paysFilm = line.substring(10, max);

                System.out.println(paysFilm);
            }

            // String urlPaysFilm = "null";
            if (line.contains("url : /se")&& derniereLigne.contains("nom : ")){
                int max = line.length() -1;
                urlPaysFilm = line.substring(10, max);
                newPays = false;

                // EST TRONQUÉ !!!
                System.out.println(urlPaysFilm);

                // TODO ICI ARRENGEMENT A FAIRE §§
                jsonMethode.addNation(paysFilm, urlPaysFilm);
            }

            // String nomFilm = "null";
            if (line.contains("nom : ") && derniereLigne.contains(("},"))){
                int max = line.length() -1;
                nomFilm = line.substring(8, max);

                System.out.println(nomFilm);
            }

            // String urlFilm = "null";
            if (line.contains("url : ") && derniereLigne.contains(("nom : "))){
                int max = line.length() -1;
                urlFilm = line.substring(8, max);

                System.out.println(urlFilm);
            }

            // String descFilm = "null";
            if (line.contains("plot : ") && derniereLigne.contains(("url : "))){
                int max = line.length() -1;
                descFilm = line.substring(10, max);

                System.out.println(descFilm);
            }

            // String langueFilm = "null";
            if (line.contains(("langue : "))){
                int max = line.length() -1;
                langueFilm = line.substring(11, max);

                // TODO ICI ARRENGEMENT A FAIRE §§

                //JsonMethode.addLangue(langueFilm);
            }


            if (line.contains("lieuTournage :") && !line.contains("null")){
                newLieuTournage = true;
            }

            // String villeTournage = "null";
            if (line.contains("ville : ") && newLieuTournage){
                int max = line.length() -1;
                villeTournage = line.substring(12, max);

                System.out.println(villeTournage);
            }

            // String etasTournage = "null";
            if (line.contains("etatDept : ") && newLieuTournage){
                int max = line.length() -1;
                etasTournage = line.substring(12, max);

                System.out.println(etasTournage);
            }

            // String paysTournage = "null";
            if (line.contains("pays : ") && newLieuTournage){
                int max = line.length() -1;
                paysTournage = line.substring(12, max);

                System.out.println(paysTournage);
            }

            // Désactive le lieu de tournage
            if (line.contains("},") && derniereLigne.contains("pays : ")){
                newLieuTournage = false;

                // TODO ICI ARRENGEMENT A FAIRE §§

                //jsonMethode.addLieu(paysTournage, etasTournage, villeTournage);
            }

            // boolean newRealisateur = false;
            if (line.contains("realisateurs : [ {")){
                newRealisateur = true;
            }

            // String nomRealisateur = null;
            // String prenomRealisateur = null;
            if (line.contains("identite : ") && newRealisateur){

                int max = line.length() -1;

                String identite = line.substring(15, max);
                String[] identiteSplits = identite.split(" ");

                for (String identiteSplit : identiteSplits){
                    System.out.println(identiteSplit);
                }

                prenomRealisateur = identiteSplits[0];

                if (identiteSplits.length > 2) {
                    nomRealisateur = identiteSplits[1] + " " + identiteSplits[2];
                } else {
                    nomRealisateur = identiteSplits[1];
                }
            }

            //String urlRealisateur = null;
            if (line.contains("url : ") && derniereLigne.contains("identite : ")){
                int max = line.length() -1;
                urlRealisateur = line.substring(10, max);
            }

            if (line.contains(" ],") && newRealisateur){
                newRealisateur = false;

                // TODO ICI ARRENGEMENT A FAIRE §§
                // jsonMethode.addPersonne(nomRealisateur, prenomRealisateur, urlRealisateur);
            }

            //boolean newActeur = false;
            if (line.contains("castingPrincipal : [ {")){
                newActeur = true;
            }

            //String idActeur = null;
            if (line.contains("id :") && newActeur){
                int max = line.length() -1;
                idActeur = line.substring(9, max);
            }

            //String nomActeur = null;
            //String prenomActeur = null;
            if (line.contains("identite : ") && newActeur){

                // REQUI7RE UN SSSSSSSSSSSSSSSSSSSPPPPPPPPPPPPPPLLLLLLLLLLLLLIIIIIIIIIIIIIIIITTTTTTTTTTTTTTTTTTT

                int max = line.length() -1;

                String identite = line.substring(15, max);
                String[] identiteSplits = identite.split(" ");

                for (String identiteSplit : identiteSplits){
                    System.out.println(identiteSplit);
                }

                prenomActeur = identiteSplits[0];

                if (identiteSplits.length > 2) {
                    nomActeur = identiteSplits[1] + " " + identiteSplits[2];
                } else {
                    nomActeur = identiteSplits[1];
                }
            }

            //Date dateNaissanceActeur = null;
            if (line.contains("dateNaissance : ") && newActeur && derniereLigne.contains("naissance : {")){
                int max = line.length() -1;
                String preDateNaissanceActeur =  line.substring(22, max);
                String[] dateSplits = preDateNaissanceActeur.split("-");

                for (String dateSplit : dateSplits){
                    System.out.println(dateSplit);
                }


                SimpleDateFormat formateur2 = new SimpleDateFormat("dd/MM/yyyy");


                int annee = Integer.parseInt(dateSplits[0]); // possible int annee;
                annee -= 1900;
                int mois = Integer.parseInt(dateSplits[1]);
                int jour = Integer.parseInt(dateSplits[2]);

                System.out.println("82 = " + annee);
                System.out.println("7 = " + mois);
                System.out.println("18 = " + jour);

                Date date = new Date(annee, mois, jour);

                dateNaissanceActeur = date;


                System.out.println("MA SUPER DATE DE LA MORT QUI TUE DES POULETS CRACHEUR DE FEU DE LA MORT QUI TUE DES POULETS [...] = " + formateur2.format(dateNaissanceActeur));
            }

            //String villeNaissanceActeur;
            //String regionNaissanceActeur;
            //String paysNaissanceActeur
            if (line.contains("lieuNaissance :") && newActeur && derniereLigne.contains("dateNaissance : ")){
                int max = line.length() -1;

                String identite = line.substring(22, max);
                String[] identiteSplits = identite.split(", ");

                for (String identiteSplit : identiteSplits){
                    System.out.println(identiteSplit);
                }

                villeNaissanceActeur = identiteSplits[0];

                if (identiteSplits.length > 2) {
                    regionNaissanceActeur = identiteSplits[1];
                    paysNaissanceActeur = identiteSplits[2];
                } else {
                    paysNaissanceActeur = identiteSplits[1];
                }

                // TODO ICI ARRENGEMENT A FAIRE §§
                jsonMethode.addAdresse(villeNaissanceActeur, regionNaissanceActeur, paysNaissanceActeur);
            }

            //String urlActeur = null;
            if (line.contains("url : /name") && newActeur){
                int max = line.length() -1;
                urlActeur = line.substring(10, max);
            }

            //String heightActeur = null;
            if (line.contains("height :") && newActeur){
                int max = line.length() -1;
                heightActeur = line.substring(12, max);
            }

            // newActeur = false
            if (line.contains("}, {") && newActeur && derniereLigne.contains("roles :")){
                newActeur = false;

                // TODO ICI ARRENGEMENT A FAIRE §§
                Personne personne = new Acteur(nomActeur, prenomActeur, urlActeur);
                Adresse adresse = new Adresse(villeNaissanceActeur, regionNaissanceActeur, paysNaissanceActeur);
                jsonMethode.addActeur(personne, dateNaissanceActeur, adresse);
            }

            // anneeSortieFilm = null;
            if (line.contains("anneeSortie :")){
                int max = line.length() -1;
                anneeSortieFilm = line.substring(16, max);
            }

            //boolean newRole = false;
            //if (line.contains("height :") && newActeur){
            //    boolean newRole = true;
            //}



            if (line.contains("characterName :")) {
                int max = line.length() -1;
                roleNom = line.substring(20, max);
            }


            if (line.contains("genres : [")) {
                int max = line.length() -1;
                String preGenreFilm = line.substring(13, max);

                genreFilm = preGenreFilm.split(", ");

                jsonMethode.addGenre(genreFilm);

                for (String genreFilme : genreFilm){
                    System.out.println("pregenre " + genreFilme);
                }
            }

            derniereLigne = line;
            //System.out.println(line);
        }

        System.out.println("id filme = " + idFilm);
        System.out.println("pays filme = " + paysFilm);
        System.out.println("url pays filme = " + urlPaysFilm);
        System.out.println("nom filme = " + nomFilm);
        System.out.println("url film = " + urlFilm);
        System.out.println("description film = " + descFilm);
        System.out.println("langue du film = " + langueFilm);
        System.out.println("ville tournage = " + villeTournage); //  valeur null dans le json
        System.out.println("etas tournage = " + etasTournage); //  valeur null dans le json
        System.out.println("pays tournage = " + paysTournage); //  valeur null dans le json
        System.out.println("nom realisateur = " + nomRealisateur);
        System.out.println("prenom realisateur = " + prenomRealisateur);
        System.out.println("url realisateur = " + urlRealisateur);
        System.out.println("idActeur = " + idActeur);
        System.out.println("nom acteur = " + nomActeur);
        System.out.println("prenom acteur = " + prenomActeur);
        //System.out.println("date naissence acteur = " + dateNaissanceActeur);
        System.out.println("ville naissance acteur = " + villeNaissanceActeur);
        System.out.println("région naissance acteur = " + regionNaissanceActeur);
        System.out.println("pays naissance acteur = " + paysNaissanceActeur);
        System.out.println("url acteur = " + urlActeur);
        System.out.println("height acteur = " + heightActeur); // valeur null a chaque fois
        System.out.println("année sortie filme = " + anneeSortieFilm); // null dans le json
        System.out.println("role nom = " + roleNom);

    }
}
