package vue;

import controller.ControllerPokemon;
import controller.ControllerType;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VueFilter extends AbstractVue implements Observer {

    private final JTextField fieldSearch = new JTextField(10);
    private final JComboBox boxType = new JComboBox();
    private final JComboBox boxGeneration = new JComboBox();
    private final JComboBox boxLimit = new JComboBox();
    private final JLabel labelSearch = new JLabel("Rechercher :");

    /*private final JLabel labelType = new JLabel("Type :");
    private final JLabel labelGeneration = new JLabel("Generation:");*/
    public VueFilter() {
        initFrame();
        this.pack();
    }

    private void initFrame() {
        ControllerType controllerType;
        controllerType = ControllerType.getInstance();

        boxType.addItem(" -- Type -- ");
        boxGeneration.addItem(" -- Generation -- ");

        boxLimit.addItem(150);
        boxLimit.addItem(250);
        boxLimit.addItem(500);
        boxLimit.addItem(1000);

        for (int i = 0; i < controllerType.getNbTypes(); i++) {
            boxType.addItem(controllerType.getType(i));
        }

        for (int i = 1; i < 9; i++) {
            boxGeneration.addItem("Generation : " + i);
        }

        //placement des objets
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.insets = new Insets(5, 18, 5, 18);

        gc.fill = GridBagConstraints.BOTH;
        gc.gridx = 0;
        gc.gridy = 1;
        this.add(labelSearch, gc);
        gc.gridx = 2;
        this.add(fieldSearch, gc);
        gc.gridx = 6;
        this.add(boxType, gc);
        gc.gridx = 7;
        this.add(boxGeneration, gc);
        gc.gridx = 8;
        this.add(boxLimit, gc);
        gc.gridwidth = 11;

        fieldSearch.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String searchValue = fieldSearch.getText().toLowerCase();
                ControllerPokemon controllerPokemon;
                controllerPokemon = ControllerPokemon.getInstance();
                controllerPokemon.setName(searchValue);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

        });

        boxLimit.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ControllerPokemon controllerPokemon;
                controllerPokemon = ControllerPokemon.getInstance();
                controllerPokemon.changeLimitPokemon((int) boxLimit.getSelectedItem());
            }
        });

        boxGeneration.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ControllerPokemon controllerPokemon;
                controllerPokemon = ControllerPokemon.getInstance();
                int gen = boxGeneration.getSelectedIndex();
                controllerPokemon.setGen(gen);
            }
        });

        boxType.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ControllerPokemon controllerPokemon;
                controllerPokemon = ControllerPokemon.getInstance();
                String type = (String) boxType.getSelectedItem();
                if (boxType.getSelectedIndex() == 0) {
                    type = "";
                }
                controllerPokemon.setType(type);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        this.remove(this);
        this.revalidate();
    }

}
