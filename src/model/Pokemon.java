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
    private int generation;
    private int hp;
    private int attack;
    private int defense;
    private ArrayList<String> types;

    public Pokemon(int id, String name, int generation, int hp, int attack, int defense) {
        this.id = id;
        this.name = name;
        this.generation = generation;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.types = new ArrayList<>();
    }

    public void addType(String type){
        types.add(type);
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

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    @Override
    public String toString() {
        String ch = "Pokemon{" + "id=" + id + ", name=" + name + ", generation=" + generation + ", hp=" + hp + ", attack=" + attack + ", defense=" + defense + ", types=";
        for(int i = 0 ; i < types.size() ; i++){
            ch += types.get(i) + " ";
        }
        ch += "}";
        return ch;
    }
  
}
