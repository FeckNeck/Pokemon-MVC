/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.AbstractController.pokedex;
import java.util.ArrayList;
import model.ApiRequest;

/**
 *
 * @author FeckNeck
 */
public class ControllerType extends AbstractController{
    private static ControllerType instance;
    private final ArrayList<String> types;
    
    private ControllerType(){
        ApiRequest api = new ApiRequest();
        api.fetchTypes();
        types = api.getTypes();
    }
    
    public static ControllerType getInstance() {
      if(instance == null) {
         instance = new ControllerType();
      }
      return instance;
   }
    
    public int FilterType(String type){
        int nbPokemon = 0;
        for(int i = 0; i < pokedex.getPokedex().size(); i++){
            ArrayList<String> pokeTypes = pokedex.getPokemon(i).getTypes();
            for(int j = 0; j < pokeTypes.size(); j++){
                if(pokeTypes.get(j).equals(type)){
                    nbPokemon++;
                }
            }
        }
        return nbPokemon;
    }
    
    public String getType(int i) {
        return types.get(i);
    }
    
    public int getNbTypes(){
        return types.size();
    }
    
}
