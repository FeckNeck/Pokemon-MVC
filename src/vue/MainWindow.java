/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controller.ControllerPokemon;
import java.io.IOException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import model.Pokedex;

/**
 *
 * @author FeckNeck
 */
public class MainWindow extends JFrame {

    private Pokedex pokedex;
    private final int space = 5;

    public MainWindow() throws IOException {

        ControllerPokemon controllerPokemon;
        controllerPokemon = ControllerPokemon.getInstance();
        pokedex = controllerPokemon.getData();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JDesktopPane());
        this.setTitle("Pokedex");

        VueFilter vueFilter = new VueFilter();
        this.add(vueFilter);
        vueFilter.setTitle("Filter Pokemons");
        vueFilter.setLocation(space, 0);
        vueFilter.setVisible(true);

        VueListe liste = new VueListe(pokedex);
        this.add(liste);
        liste.setTitle("Pokemon list");
        liste.setLocation(space, vueFilter.getHeight() + space * 5);
        liste.setVisible(true);

        VueCamembertChart camembert = new VueCamembertChart(pokedex);
        this.add(camembert);
        camembert.setTitle("Répartition par type");
        camembert.setVisible(true);
        camembert.setLocation(liste.getWidth() + (space * 10), 0);

        VueHistogrammeChart histo = new VueHistogrammeChart();
        this.add(histo);
        histo.setTitle("Répartition par génération");
        histo.setVisible(true);
        histo.setLocation(liste.getWidth() + (space * 10), camembert.getHeight() + space * 5);

        pokedex.addObserver(liste);
        pokedex.addObserver(camembert);
        pokedex.addObserver(histo);
        pokedex.addObserver(vueFilter);

        this.setSize(liste.getWidth() + camembert.getWidth() + (space * 20), camembert.getHeight() + histo.getHeight() + (space * 20));
    }

}
