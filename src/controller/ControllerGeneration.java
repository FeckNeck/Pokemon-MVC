/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pokemon;

/**
 *
 * @author FeckNeck
 */
public class ControllerGeneration extends AbstractController {

    private static ControllerGeneration instance;
    private final int nbGeneration = 9;

    private ControllerGeneration() {

    }

    public int getNbGeneration() {
        return nbGeneration;
    }

    public static ControllerGeneration getInstance() {
        if (instance == null) {
            instance = new ControllerGeneration();
        }
        return instance;
    }

    public int filterGeneration(int gen) {
        int nbPokemon = 0;
        for (Pokemon poke : pokedex.getPokedex()) {
            if (poke.getGeneration() == gen) {
                nbPokemon++;
            }
        }
        return nbPokemon;
    }
}
