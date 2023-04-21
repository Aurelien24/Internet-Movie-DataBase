package dev;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.domain.Langue;
import dev.domain.Film;

import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLDataException;
import java.sql.SQLOutput;
import java.util.*;

import jakarta.persistence.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;


public class AddFileJson {

    public static void main(String[] args) throws SQLDataException, IOException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mainPersistence");
        EntityManager em = entityManagerFactory.createEntityManager();

        JSONParser parser = new JSONParser();
        JsonMethode jsonMethode = new JsonMethode();


        try{

            Map<String, String> langues = new HashMap<>();
            Map<String, String> adresses = new HashMap<>(); // Faudra ajouté l'Id

            JSONArray a = (JSONArray) parser.parse(new FileReader("films.json"));
            for (Object o : a){
                JSONObject obj = (JSONObject) o;
                String lang = (String) obj.get("langue");

                //System.out.println("Langue : " + lang);




                if (null != lang && !Objects.equals(lang, "") && !Objects.equals(lang, "null") && !langues.containsKey(lang)) {
                    jsonMethode.addLangue(lang, em);
                    langues.put(lang, lang);
                }



                JSONObject lieux = (JSONObject) obj.get("lieuTournage");

                String villeTournage = null;
                String etasTournage = null;
                String paysTournage = "Bubu";

                //System.out.println("Lieux : " + lieux);


                if (lieux != null){

                    int max = lieux.toJSONString().length() -1;
                    String lieux2 = lieux.toJSONString().substring(1, max);
                    //System.out.println(lieux2);

                    //lieux2.split(",");
                    //JSONArray lieuxJSON = (JSONArray) parser.parse(lieux2);

                    String[] lieuxJSON = lieux2.split(",");

                   for (String lieu : lieuxJSON){
                        //System.out.println(lieu);

                        if (lieu.contains("ville")){
                            int max2 = lieu.length() -1;
                            if (max2 > 12){
                                villeTournage = lieu.substring(9, max2);
                               // System.out.println("villeTournage = " + villeTournage);
                            }
                        } else if (lieu.contains("etatDept")){
                            int max2 = lieu.length() -1;
                            if (max2 > 15){
                                etasTournage = lieu.substring(13, max2);
                                //System.out.println("etasTournage = " + etasTournage);
                            }

                        }else if (lieu.contains("pays")){
                            int max2 = lieu.length() -1;
                            if (max2 > 10){
                                paysTournage = lieu.substring(9, max2);
                                //System.out.println("paysTournage = " + paysTournage);
                                adresses.put(villeTournage, etasTournage);
                                jsonMethode.addAdresse(villeTournage,etasTournage,paysTournage);
                            } else {
                                System.out.println("ALLERTE AU GOGOLE !!!");
                            }
                        }
                    }



                    // Potentiel méthode JSON 1
                    //JSONArray lieux2 = (JSONArray) obj.get("lieuTournage");
                    //System.out.println(lieux2);
                }

                /*for (Object lieu : lieux){
                    JSONObject sousObj = (JSONObject) lieu;

                    villeTournage = (String) sousObj.get("ville");
                    etasTournage = (String) sousObj.get("etatDept");
                    paysTournage = (String) sousObj.get("pays");

                    if (paysTournage != null){
                        jsonMethode.addAdresse(villeTournage, etasTournage, paysTournage);
                    }
                }*/

/*
                if (jsonArray != null){
                    for( Object item : jsonArray) {
                        String genre = (String) item;
                        System.out.println(item);
                        if (!adresses.containsKey(genre)) {
                            //JsonMethode.addAdresse();
                            //adresses.put(genre, genre);
                        }
                    }
                }*/



                //if (null != paysTournage){
                //    jsonMethode.addAdresse(villeTournage, etasTournage, paysTournage);
                //}

                //String ligne = o.toString();
                //System.out.println(ligne);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }


        em.close();

    }




}
