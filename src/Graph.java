import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// For Graph GUI
import javax.swing.*;

public class Graph extends JFrame {

    public Graph() {

        XYSeriesCollection data = new XYSeriesCollection();

        int[] n = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        // Changed 0.0 to 0.01 to avoid errors in rendering the graph
        double[] bubble    = {0.05, 0.2, 0.45, 1.5, 8.5, 28.55, 111.0, 2930.95, 15904.7};
        double[] insertion = {0.01, 0.1, 0.05, 0.2, 0.95, 3.35, 14.4, 202.5, 816.95};
        double[] selection = {0.05, 0.15, 0.2, 0.55, 3.35, 12.85, 50.2, 700.75, 2782.9};
        double[] shell     = {0.05, 0.05, 0.05, 0.15, 0.25, 0.7, 1.25, 6.05, 13.35};
        double[] quick     = {0.01, 0.01, 0.05, 0.05, 0.15, 0.3, 0.7, 2.9, 5.9};
        double[] merge     = {0.01, 0.01, 0.01, 0.15, 0.45, 0.7, 1.2, 5.0, 10.4};

        // Adds data to Collection
        data.addSeries(make("BubbleSort", n, bubble));
        data.addSeries(make("InsertionSort", n, insertion));
        data.addSeries(make("SelectionSort", n, selection));
        data.addSeries(make("ShellSort", n, shell));
        data.addSeries(make("QuickSort", n, quick));
        data.addSeries(make("MergeSort", n, merge));

        // Creates Chart Base
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Sorting Time For Different Algorithms",
                "N - Size of Array",
                "Avg Time (ms)",
                data,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );


        // Sets scale
        XYPlot plot = chart.getXYPlot();
        plot.setRangeAxis(new LogAxis(" Avg Time (ms)"));

        setContentPane(new ChartPanel(chart));
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // turns 2 arrays into a XY Series
    private XYSeries make(String name, int[] x, double[] y) {
        XYSeries s = new XYSeries(name);
        for (int i = 0; i < x.length; i++) {
            double v = y[i];
            s.add(x[i], v);
        }
        return s;
    }

    // Starts graph
    public static void main(String[] args) {
        new Graph().setVisible(true);
    }
}
