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

            JSONArray a = (JSONArray) parser.parse(new FileReader("films.json"));
            for (Object o : a){
                JSONObject obj = (JSONObject) o;
                String lang = (String) obj.get("langue");
                String nomFilm = (String) obj.get("nom");
                System.out.println("Langue : " + lang);

                if (null != lang && !Objects.equals(lang, "") && !Objects.equals(lang, "null") && !langues.containsKey(lang)) {
                    jsonMethode.addLangue(lang, em);
                    langues.put(lang, lang);
                }
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
