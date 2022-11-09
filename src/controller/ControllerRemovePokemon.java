/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pokedex;
import model.Pokemon;

/**
 *
 * @author FeckNeck
 */
public class ControllerRemovePokemon extends AbstractControleur{

    private final int index;
        
    public ControllerRemovePokemon(Pokedex data, int index) {
        this.data = data;
        this.index = index;
        control();
    }

    @Override
    public final void control() {
        int id = data.getPokemon(index).getId();
        Pokemon poke = data.filterId(id);
        if(poke != null) {
            data.removePokemon(poke);
       }
    }
    
}
