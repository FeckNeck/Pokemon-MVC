package vue;

import controller.ControllerType;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import model.Pokedex;

public final class VueCamembertChart extends AbstractVue implements Observer{

    private Camembert camemb;
    protected Pokedex data;

    public VueCamembertChart(Pokedex data) {
        this.data = data;
        initCamembert();
    }

    public void initCamembert(){
        camemb = new Camembert();
        this.setContentPane(camemb);
        this.pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.remove(camemb);
        initCamembert();
        this.revalidate();
    }
    
// internal class
    public class Camembert extends ChartPanel {

        public Camembert() {
            super(null);
            this.setPreferredSize(new Dimension(450, 350));
            final PieDataset dataset = createSampleDataset();
            final JFreeChart chart = createChart(dataset);
            final ChartPanel chartPanel = new ChartPanel(chart);
            setContentPane(chartPanel);
            this.setChart(chart);
        }

        private PieDataset createSampleDataset() {
            final DefaultPieDataset result = new DefaultPieDataset();
            
            ControllerType controllerType;
            controllerType = ControllerType.getInstance();
            
            for(int i = 0; i < controllerType.getNbTypes(); i++){
                String type = controllerType.getType(i);
                int nbPokemon = controllerType.FilterType(type);
                if(nbPokemon > 0) {
                    result.setValue(type, nbPokemon);
                }
            }
            return result;
        }

        private JFreeChart createChart(final PieDataset dataset) {
            final JFreeChart chart = ChartFactory.createPieChart3D(
                    "", // chart title
                    dataset, // data
                    true, // include legend
                    true,
                    false
            );
            final PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(290);
            plot.setDirection(Rotation.CLOCKWISE);
            plot.setForegroundAlpha(0.5f);
            plot.setNoDataMessage("No data to display");
            return chart;
        }
    }
}
