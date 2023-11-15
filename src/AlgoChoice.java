import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

@SuppressWarnings("all")
public class AlgoChoice implements ActionListener {

    enum Algorithm {
        BUBBLE_SORT,
        INSERTION_SORT, 
        MERGE_SORT
    };

    private Algorithm algoChoice = Algorithm.BUBBLE_SORT;
    private String[] algoLabels = {"Bubble Sort", "Insertion Sort", "Merge Sort"};
    private JComboBox<String> algoButton;
    
    public AlgoChoice() {
        algoButton = new JComboBox<>(algoLabels);
        algoButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        JComboBox<String> cb = (JComboBox<String>)e.getSource();
        int choice = cb.getSelectedIndex();
        algoChoice = Algorithm.values()[choice];
    }

    public JComboBox<String> getComponent() {
        return this.algoButton;
    }

    public Algorithm getAlgorithm() {
        return this.algoChoice;
    }
    
}
