import java.awt.Color;

public class AlgorithmHandler {

    public final int SCREEN_HEIGHT = 800;
    public final int SCREEN_WIDTH = 1200;

    public final long TIMEOUT = 1;
    
    Collection barCollection;

    public AlgorithmHandler(Collection c) {
        this.barCollection = c;
    }

    public void BubbleSort(SortVis sortVisualizer) throws InterruptedException {
        for (int i = 0; i < barCollection.getBars().size() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < barCollection.getBars().size() - 1 - i; j++) {
                if (barCollection.getBars().get(j).getHeight() > barCollection.getBars().get(j + 1).getHeight()) {
                    barCollection.swap(j, j + 1);
                    swapped = true;
                    barCollection.repaint(sortVisualizer);                }
            }
            if (!swapped) {
                break;
            }
        }
        barCollection.changeCollectionColor(Color.GREEN);
        barCollection.repaint(sortVisualizer);
    }

    public void InsertionSort(SortVis sortVisualizer) throws InterruptedException {
        for (int i = 1; i < barCollection.getBars().size(); i++) {
            int key = barCollection.getBars().get(i).getHeight();
            int j =  i - 1;
            while (j >= 0 && barCollection.getBars().get(j).getHeight() > key) {
                barCollection.swap(j, j + 1);
                barCollection.repaint(sortVisualizer);
                j--;
            }
            barCollection.getBars().get(j + 1).setHeight(key);
            barCollection.repaint(sortVisualizer);
        }
    }
}
