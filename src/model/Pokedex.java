/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author FeckNeck
 */
public class Pokedex {
    private ArrayList<Pokemon> pokedex;

    public Pokedex() {
        this.pokedex = new ArrayList<>();
    }
    
    public void addPokemon(Pokemon pokemon){
        pokedex.add(pokemon);
    }
    
    public void removePokemon(Pokemon pokemon){
        pokedex.remove(pokemon);
    }
    
    @Override
    public String toString() {
        String listPokemon ="";
        for (int i = 0; i < pokedex.size(); i++) { 		      
            listPokemon += pokedex.get(i).toString();
        }
        return listPokemon;
    }
    
}
