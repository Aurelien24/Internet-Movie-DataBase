package dev;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.domain.Adresse;
import dev.domain.Langue;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import static java.lang.Character.highSurrogate;


public class AddFileJson {
    public static void main(String[] args) throws IOException {

        JSONParser parser = new JSONParser();
        JsonMethode jsonMethode = new JsonMethode();

        try{
            JSONArray a = (JSONArray) parser.parse(new FileReader("films.json"));
            for (Object o : a){
                JSONObject obj = (JSONObject) o;
                String lang = (String) obj.get("langue");
                System.out.println("Langue : " + lang);

                //JsonMethode.create_language(lang);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ParseException e){
            e.printStackTrace();
        }

    }
}
