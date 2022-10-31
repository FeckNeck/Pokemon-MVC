/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author FeckNeck
 */
public final class ApiRequest {
    
    private static final String URL_POKEMON = "https://pokebuildapi.fr/api/v1/pokemon/limit/100";
    private final Pokedex pokedex;
    
    public ApiRequest() {
        pokedex = new Pokedex();
        fetchApi();
    }
    
    public void fetchApi(){
        try {
            URL url = new URL(URL_POKEMON);
            HttpURLConnection  urlConnection = (HttpURLConnection) url.openConnection();
            
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
               		
		String inputLine;
		StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                                               
                JSONArray object = new JSONArray(response.toString());
                
                for(int i = 0 ; i < object.length() ; i++){
                    JSONObject pokeObject = object.getJSONObject(i);
                    
                    int id = pokeObject.getInt("pokedexId");
                    String name = pokeObject.getString("name");
                    String generation = pokeObject.getString("generation");
                    Pokemon pokemon = new Pokemon(id, name, generation);
                    
                    JSONArray types = pokeObject.getJSONArray("apiTypes");
                    for(int j = 0 ; j < types.length() ; j++){
                        JSONObject xd = (JSONObject) types.get(j);
                        System.out.println(xd.get("name"));
                    }
                }
                in.close();   // et on ferme le flux
            }
        } catch (MalformedURLException e) {
            System.out.println(e + "pb url");
        } catch(IOException e){
            System.out.println(e + "pb d'acces au serveur");
        }
    }
    
}
