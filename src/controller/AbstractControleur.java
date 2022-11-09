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
public abstract class AbstractControleur {
    
    protected Pokedex data;
    
    public abstract void control();
     
    public AbstractControleur(){
       
    }
     
}
