/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import model.Pokedex;
import model.Pokemon;
import controller.ControllerRemovePokemon;
/**
 *
 * @author FeckNeck
 */
public final class VueListe extends AbstractVue implements Observer{

    private JList liste;
    private final JButton btSuppr = new JButton("Supprimer");
    protected Pokedex data;
    private Pokemon [] pokedex;
    
    VueListe(Pokedex pokedex) throws IOException {
        this.data = pokedex;
        initList();
    }
    
    public void initList() throws IOException{
        
        liste = new JList();
        liste.setLayoutOrientation(JList.VERTICAL);

        JScrollPane scrollPane = new JScrollPane(liste);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 0;
        this.add(scrollPane, gc);
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(btSuppr, gc);

        fillList();
        liste.setVisibleRowCount(this.getHeight()/8);
        this.pack();
       
       btSuppr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
                if(e.getSource() == btSuppr){ 
                    int index = liste.getSelectedIndex();
                    if(index != -1){
                        ControllerRemovePokemon controller = new ControllerRemovePokemon(data, index);
                    }
                }      
            }            

       });
       this.pack();
    }

    private void fillList() {
        pokedex = new Pokemon[data.getPokedex().size()];

        for(int i=0; i < data.getPokedex().size(); i++){
            pokedex[i] = data.getPokemon(i);
        }

        liste.removeAll();
        liste.setListData(pokedex);
        this.pack();
    }
        
    @Override
    public void update(Observable o, Object arg) {
        this.remove(this);
        fillList();
        this.revalidate();
    }
    
}
