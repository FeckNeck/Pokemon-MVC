/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon.mvc;

import java.io.IOException;
import vue.MainWindow;

/**
 *
 * @author FeckNeck
 */
public class PokemonMvc {

    public static void main(String[] args) throws IOException {
        MainWindow fen = new MainWindow();
        fen.setVisible(true);
        /*ControllerPokemon control;
        control = ControllerPokemon.getInstance();
        System.out.println(control.getPokedex());
        ControllerType control2;
        control2 = ControllerType.getInstance();

        System.out.println(control2.getPokedex());*/
    }

}
