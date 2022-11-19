/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.ApiRequest;
import model.Pokemon;

/**
 *
 * @author FeckNeck
 */
public final class ControllerPokemon extends AbstractController {

    private static ControllerPokemon instance;
    ArrayList<Pokemon> copiedPokedex;
    ApiRequest api;
    private int limit = 0, gen = 0;
    private String name = "", type = "";

    private ControllerPokemon() {
        api = new ApiRequest();
        loadPokemons();
    }

    public static ControllerPokemon getInstance() {
        if (instance == null) {
            instance = new ControllerPokemon();
        }
        return instance;
    }

    public void loadPokemons() {
        api.fetchPokemons();
        pokedex = api.getPokedex();
        copiedPokedex = new ArrayList<>(pokedex.getPokedex());
    }

    public Pokemon filterId(int id) {
        for (int i = 0; i < pokedex.getPokedex().size(); i++) {
            if (pokedex.getPokemon(i).getId() == id) {
                return pokedex.getPokemon(i);
            }
        }
        return null;
    }

    /*public void filterName(String name) {
        pokedex.getPokedex().clear();
        copiedPokedex.stream().filter((poke) -> (poke.getName().toLowerCase().contains(name))).forEachOrdered((poke) -> {
            pokedex.addPokemon(poke);
        });
    }

    public void filterGeneration(int gen) {
        pokedex.getPokedex().clear();
        for (int i = 0; i < copiedPokedex.size(); i++) {
            if (copiedPokedex.get(i).getGeneration() == gen) {
                pokedex.addPokemon(copiedPokedex.get(i));
            }
        }
    }

    public void filterType(String type) {
        pokedex.getPokedex().clear();
        for (int i = 0; i < copiedPokedex.size(); i++) {
            ArrayList<String> pokeTypes = copiedPokedex.get(i).getTypes();
            for (int j = 0; j < pokeTypes.size(); j++) {
                if (pokeTypes.get(j).equals(type)) {
                    pokedex.addPokemon(copiedPokedex.get(i));
                }
            }
        }
    }*/
    public void globalFilter() {
        pokedex.getPokedex().clear();

        if (gen > 0 && type.length() == 0) {
            copiedPokedex.stream().filter((poke) -> (poke.getName().toLowerCase().contains(name)) && poke.getGeneration() == gen).forEachOrdered((poke) -> {
                pokedex.addPokemon(poke);
            });
        } else if (type.length() > 0 && gen == 0) {
            copiedPokedex.stream().filter((poke) -> (poke.getName().toLowerCase().contains(name)) && poke.getTypes().get(0).equals(type)).forEachOrdered((poke) -> {
                pokedex.addPokemon(poke);
            });
        } else if (type.length() > 0 && gen > 0) {
            copiedPokedex.stream().filter((poke) -> (poke.getName().toLowerCase().contains(name))
                    && poke.getTypes().get(0).equals(type)
                    && poke.getGeneration() == gen
            ).forEachOrdered((poke) -> {
                pokedex.addPokemon(poke);
            });
        } else {
            copiedPokedex.stream().filter((poke) -> (poke.getName().toLowerCase().contains(name))).forEachOrdered((poke) -> {
                pokedex.addPokemon(poke);
            });
        }

    }

    public void removePokemon(int index) {
        int id = pokedex.getPokemon(index).getId();
        Pokemon poke = filterId(id);
        if (poke != null) {
            pokedex.removePokemon(poke);
        }
    }

    public void changeLimitPokemon(int limit) {
        api.setLimit(limit);
        loadPokemons();
        globalFilter();
    }

    public void setGen(int gen) {
        this.gen = gen;
        globalFilter();
    }

    public void setName(String name) {
        this.name = name;
        globalFilter();
    }

    public void setType(String type) {
        this.type = type;
        globalFilter();
    }

}
