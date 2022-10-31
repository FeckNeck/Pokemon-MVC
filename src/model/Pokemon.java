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
public class Pokemon {
    private int id;
    private String name;
    private String generation;
    private ArrayList<String> types;
    private ArrayList<Integer> stats;

    public Pokemon(int id, String name, String generation) {
        this.id = id;
        this.name = name;
        this.generation = generation;
        this.types = new ArrayList<>();
        this.stats = stats = new ArrayList<>();
    }
    
    public void addType(String type){
        types.add(type);
    }
    
    public void addStat(Integer stat){
        stats.add(stat);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneration() {
        return generation;
    }

    public void setGeneration(String generation) {
        this.generation = generation;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public ArrayList<Integer> getStats() {
        return stats;
    }

    public void setStats(ArrayList<Integer> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", name=" + name + ", generation=" + generation + ", types=" + types + ", stats=" + stats + '}';
    }


    
    
}
