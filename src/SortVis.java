import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

@SuppressWarnings("all")
public class SortVis extends JPanel {

    public static final Color WHITE = Color.WHITE;
    public static final Color BLACK = Color.BLACK;
    public static final Color GREEN = Color.GREEN;

    public static final int SCREEN_HEIGHT = 800;
    public static final int SCREEN_WIDTH = 1200;

    public static final int NUM_BARS = 100;
    public static Collection barCollection = new Collection();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(WHITE);
        barCollection.drawCollection(g);
    }

    public static void main(String args[]) {

        SortVis sortVisualizer = new SortVis();
        JFrame frame = new JFrame();
        frame.setTitle("SORTING VISUALIZER");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

        // Generate Data Set Button
        JButton generateDataButton = new JButton("Generate Data");
        ActionListener generateDataListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                barCollection = new Collection(NUM_BARS);
                sortVisualizer.repaint();
            }
        };
        generateDataButton.addActionListener(generateDataListener);
        sortVisualizer.add(generateDataButton);

        // Algorithm Choice Button
        AlgoChoice algoChoiceButton = new AlgoChoice();
        sortVisualizer.add(algoChoiceButton.getComponent());

        // Sort Button
        JButton sortButton = new JButton("Sort");
        ActionListener sortActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AlgorithmHandler handler = new AlgorithmHandler(barCollection);
                if (algoChoiceButton.getAlgorithm() == AlgoChoice.Algorithm.BUBBLE_SORT) {
                    try {
                        handler.bubbleSort(sortVisualizer);
                    } catch (InterruptedException i) {
                        i.printStackTrace();
                    }
                }
                if (algoChoiceButton.getAlgorithm() == AlgoChoice.Algorithm.INSERTION_SORT) {
                    try {
                        handler.insertionSort(sortVisualizer);
                    } catch (InterruptedException i) {
                        i.printStackTrace();
                    }
                }
                if (algoChoiceButton.getAlgorithm() == AlgoChoice.Algorithm.MERGE_SORT) {
                    handler.mergeSort(sortVisualizer, 0, barCollection.getBars().size() - 1);
                }
                barCollection.changeCollectionColor(GREEN);
                barCollection.repaint(sortVisualizer);
            }
        };
    
        sortButton.addActionListener(sortActionListener);
        sortVisualizer.add(sortButton);

        
        frame.add(sortVisualizer);

        frame.setVisible(true);
    }

}
