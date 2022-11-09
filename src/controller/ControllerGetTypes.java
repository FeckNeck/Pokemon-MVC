/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.ApiRequest;

/**
 *
 * @author FeckNeck
 */
public class ControllerGetTypes extends AbstractControleur{

    ArrayList<String> types;
    
    public ControllerGetTypes() {
        ApiRequest api = new ApiRequest();
        api.fetchTypes();
        types = api.getTypes();
    }

    public String getType(int i) {
        return types.get(i);
    }
    
    public int getNbTypes(){
        return types.size();
    }

    @Override
    public void control() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
