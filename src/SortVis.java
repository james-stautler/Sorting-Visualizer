import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

@SuppressWarnings("all")
public class SortVis extends Canvas {

    public static final Color WHITE = Color.WHITE;

    private static final int SCREEN_HEIGHT = 800;
    private static final int SCREEN_WIDTH = 1200;

    private static final int ALGO_CHOICE_BUTTON_X = 500;
    private static final int ALGO_CHOICE_BUTTON_Y = 700;
    private static final int ALGO_CHOICE_BUTTON_WIDTH = 200;
    private static final int ALGO_CHOICE_BUTTON_HEIGHT = 25;

    public void paint(Graphics g) {
        setBackground(WHITE);
    }

    public static void main(String args[]) {
        SortVis sortVisualizer = new SortVis();
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(sortVisualizer);
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

        AlgoChoice algoChoiceButton = new AlgoChoice();
        algoChoiceButton.setSize(ALGO_CHOICE_BUTTON_WIDTH, ALGO_CHOICE_BUTTON_HEIGHT);
        algoChoiceButton.setLocation(ALGO_CHOICE_BUTTON_X, ALGO_CHOICE_BUTTON_Y);
        frame.add(algoChoiceButton.getComponent());

        frame.setVisible(true);
    }
}
