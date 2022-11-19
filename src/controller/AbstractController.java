/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Pokedex;

/**
 *
 * @author FeckNeck
 */
public abstract class AbstractController {
    
    protected static Pokedex pokedex;
     
    public AbstractController(){
       
    }
 
    public Pokedex getData() {
        return pokedex;
    }
}
