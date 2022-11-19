package vue;

import controller.ControllerGeneration;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class VueHistogrammeChart extends AbstractVue implements Observer {

    private Histogramme histo;

    public VueHistogrammeChart() {
        histo = new Histogramme();
        this.setContentPane(histo);
        this.pack();
    }

    public void initHistogramme() {
        histo = new Histogramme();
        this.setContentPane(histo);
        this.pack();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.remove(histo);
        initHistogramme();
        this.revalidate();
    }

    // internal class
    public class Histogramme extends ChartPanel {

        public Histogramme() {
            super(null);
            this.setPreferredSize(new Dimension(450, 350));
            CategoryDataset dataset = createDataset();
            final JFreeChart chart = createChart(dataset);
            this.setChart(chart);
        }

        private CategoryDataset createDataset() {
            final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            ControllerGeneration controllerGen;
            controllerGen = ControllerGeneration.getInstance();

            for (int i = 0; i < controllerGen.getNbGeneration(); i++) {
                int nbPokemon = controllerGen.filterGeneration(i);
                if (nbPokemon > 0) {
                    dataset.addValue(nbPokemon, "Generation " + i, "Generation " + i);
                }
            }

            return dataset;
        }

        private JFreeChart createChart(final CategoryDataset dataset) {
            final JFreeChart chart = ChartFactory.createBarChart3D(
                    "", // chart title
                    "", // domain axis label
                    "", // range axis label
                    dataset, // data
                    PlotOrientation.VERTICAL, // orientation
                    true, // include legend
                    true, // tooltips
                    false // urls
            );

            final CategoryPlot plot = chart.getCategoryPlot();
            final CategoryAxis axis = plot.getDomainAxis();
            axis.setCategoryLabelPositions(
                    CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 8.0)
            );
            final BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();
            renderer.setDrawBarOutline(false);

            return chart;

        }

    }

}
