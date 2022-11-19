/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author FeckNeck
 */
public class Pokedex extends Observable {

    private ArrayList<Pokemon> pokedex;

    public Pokedex() {
        this.pokedex = new ArrayList<>();
    }

    public ArrayList<Pokemon> getPokedex() {
        return pokedex;
    }

    public void setPokedex(ArrayList<Pokemon> pokedex) {
        this.pokedex = pokedex;
    }

    public Pokemon getPokemon(int i) {
        return pokedex.get(i);
    }

    public void addPokemon(Pokemon pokemon) {
        pokedex.add(pokemon);
        setChanged();
        notifyObservers();
    }

    public void removePokemon(Pokemon pokemon) {
        pokedex.remove(pokemon);
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        String listPokemon = "";
        for (int i = 0; i < pokedex.size(); i++) {
            listPokemon += pokedex.get(i).toString() + "\n";
        }
        return listPokemon;
    }

}
