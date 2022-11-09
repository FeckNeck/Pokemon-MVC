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
    
    private static final String URL_POKEMON = "https://pokebuildapi.fr/api/v1/pokemon/limit/10";
    private static final String URL_TYPES = "https://pokebuildapi.fr/api/v1/types";
    
    private final Pokedex pokedex;
    private ArrayList<String> types;
    
    public ApiRequest() {
        pokedex = new Pokedex();
    }
    
    public void fetchPokemons(){
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
                    int generation = pokeObject.getInt("apiGeneration");
                    String name = pokeObject.getString("name");
                    
                    JSONObject stats = pokeObject.getJSONObject("stats");
                    
                    int hp = stats.getInt("HP");
                    int attack = stats.getInt("attack");
                    int defense = stats.getInt("defense");
                    Pokemon pokemon = new Pokemon(id, name, generation, hp, attack, defense);
                    
                    JSONArray types = pokeObject.getJSONArray("apiTypes");
                    for(int j = 0 ; j < types.length() ; j++){
                        JSONObject type = (JSONObject) types.get(j);
                        pokemon.addType(type.getString("name"));
                    }
                    
                    pokedex.addPokemon(pokemon);
                }
                in.close();
            }
        } catch (MalformedURLException e) {
            System.out.println(e + "pb url");
        } catch(IOException e){
            System.out.println(e + "pb d'acces au serveur");
        }
    }
    
    public void fetchTypes(){
         try {
            URL url = new URL(URL_TYPES);
            HttpURLConnection  urlConnection = (HttpURLConnection) url.openConnection();
            
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
                types = new ArrayList<>();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
               		
		String inputLine;
		StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                                               
                JSONArray object = new JSONArray(response.toString());
                
                for(int i = 0 ; i < object.length() ; i++){
                    JSONObject typeObject = object.getJSONObject(i);
                    types.add(typeObject.getString("name"));
                }
                in.close();
            }
        } catch (MalformedURLException e) {
            System.out.println(e + "pb url");
        } catch(IOException e){
            System.out.println(e + "pb d'acces au serveur");
        }
    }
    
    public Pokedex getPokedex() {
        return pokedex;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

}
