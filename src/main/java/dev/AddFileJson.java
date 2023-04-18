package dev;

import ch.qos.logback.core.pattern.parser.Parser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import dev.domain.Adresse;
import dev.domain.Langue;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;

import static java.lang.Character.highSurrogate;


public class AddFileJson {
    public static void main(String[] args) throws IOException {
        //JSONObject jsonO = new JSONObject();
        /*File file = new File("test.txt");

        Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();*/

        File file = new File("test.json");
        Reader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);

        String line;

        // FAIRE UN FILME :
        String derniereLigne = null;

        boolean newFilm = true;
        String idFilm = null;

        boolean newPays = false;
        String paysFilm = null;
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
        String dateNaissanceActeur = null;
        String lieuNaissanceActeur = null;
        String urlActeur = null;
        String heightActeur = null;

        boolean role = false;
        String roleNom = null;
        // Ce sont des acteur qui sont dans role après

        // Ajout de boolean pour connaitre les sous objets

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
                langueFilm = line.substring(12, max);

                System.out.println(langueFilm);
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
            }

            // boolean newRealisateur = false;
            if (line.contains("realisateurs : [ {")){
                newRealisateur = true;
            }

            // String nomRealisateur = null;
            // String prenomRealisateur = null;
            if (line.contains("identite : ") && newRealisateur){

                // requière un split

                int max = line.length() -1;
                nomRealisateur = line.substring(12, max);
                prenomRealisateur = line.substring(12, max);
            }

            //String urlRealisateur = null;
            if (line.contains("url : ") && derniereLigne.contains("identite : ")){
                int max = line.length() -1;
                urlRealisateur = line.substring(10, max);
            }

            if (line.contains(" ],") && newRealisateur){
                newRealisateur = false;
            }

            derniereLigne = line;
            System.out.println(line);
        }


        System.out.println("id filme = " + idFilm);
        System.out.println("pays filme = " + paysFilm);
        System.out.println("url pays filme = " + urlPaysFilm);
        System.out.println("nom filme = " + nomFilm);
        System.out.println("url film = " + urlFilm);
        System.out.println("description film = " + descFilm);
        System.out.println("ville tournage = " + villeTournage); //  valeur null dans le json
        System.out.println("etas tournage = " + etasTournage); //  valeur null dans le json
        System.out.println("pays tournage = " + paysTournage); //  valeur null dans le json
        System.out.println("nom realisateur = " + nomRealisateur);
        System.out.println("prenom realisateur = " + prenomRealisateur);
        System.out.println("url realisateur = " + urlRealisateur);


    }
}
