/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.io.IOException;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import model.ApiRequest;
import model.Pokedex;

/**
 *
 * @author FeckNeck
 */
public class MainWindow extends JFrame {

    private Pokedex pokedex;
    private final int space = 5;
    
    public MainWindow() throws IOException {
        
        ApiRequest api = new ApiRequest();
        api.fetchPokemons();
        pokedex = api.getPokedex();
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new JDesktopPane());
        this.setTitle("Pokedex");
        
        VueListe liste = new VueListe(pokedex);
        this.add(liste);
        liste.setTitle("Pokemon list");
        liste.setLocation(space, 0);
        liste.setVisible(true);
        
        VueCamembertChart camembert = new VueCamembertChart(pokedex);
        this.add(camembert);
        camembert.setTitle("Répartition par type");
        camembert.setVisible(true);
        camembert.setLocation(liste.getWidth()+(space*2),0);
        
        VueHistogrammeChart histo = new VueHistogrammeChart(pokedex);
        this.add(histo);
        histo.setTitle("Répartition par génération");
        histo.setVisible(true);
        histo.setLocation(liste.getWidth()+(space*2), camembert.getHeight()+space);
        
        pokedex.addObserver(liste);
        pokedex.addObserver(camembert);
        pokedex.addObserver(histo);

        this.setSize(liste.getWidth()+camembert.getWidth()+(space*6),camembert.getHeight()+histo.getHeight()+(space*10));
    }
    
}
