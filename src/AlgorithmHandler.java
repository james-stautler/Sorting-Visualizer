import java.awt.Color;
import java.util.ArrayList;

public class AlgorithmHandler {

    public final int SCREEN_HEIGHT = 800;
    public final int SCREEN_WIDTH = 1200;

    public final long TIMEOUT = 1;
    
    Collection barCollection;

    public int numComparisons = 0;

    public AlgorithmHandler(Collection c) {
        this.barCollection = c;
    }

    public void resetStatistics() {
        this.numComparisons = 0;
    }

    public int getNumComparisons() {
        return this.numComparisons;
    }

    public void bubbleSort(SortVis sortVisualizer) throws InterruptedException {
        for (int i = 0; i < barCollection.getBars().size() - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < barCollection.getBars().size() - 1 - i; j++) {
                if (barCollection.getBars().get(j).getHeight() > barCollection.getBars().get(j + 1).getHeight()) {
                    this.numComparisons++;
                    barCollection.swap(j, j + 1);
                    barCollection.getBars().get(j).setColor(Color.BLACK);
                    barCollection.getBars().get(j + 1).setColor(Color.ORANGE);
                    swapped = true;
                    barCollection.repaint(sortVisualizer);                
                }
                this.numComparisons++; // make up for the first comparison if the condition is not met
                barCollection.changeCollectionColor(Color.BLACK);
                barCollection.repaint(sortVisualizer);
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void insertionSort(SortVis sortVisualizer) throws InterruptedException {
        for (int i = 1; i < barCollection.getBars().size(); i++) {
            int key = barCollection.getBars().get(i).getHeight();
            int j =  i - 1;
            barCollection.getBars().get(i).setColor(Color.ORANGE);
            barCollection.repaint(sortVisualizer);
            while (j >= 0 && barCollection.getBars().get(j).getHeight() > key) {
                this.numComparisons++;
                barCollection.swap(j, j + 1);
                barCollection.getBars().get(j).setColor(Color.ORANGE);
                barCollection.getBars().get(j + 1).setColor(Color.BLACK);
                barCollection.repaint(sortVisualizer);
                j--;
            }
            this.numComparisons++;
            barCollection.getBars().get(j + 1).setHeight(key);
            barCollection.changeCollectionColor(Color.BLACK);
            barCollection.repaint(sortVisualizer);
        }
    }

    public void merge(SortVis sortVisualizer, int l, int m, int r) throws InterruptedException {
        int n1 = m - l + 1;
        int n2 = r - m;

        ArrayList<Integer> leftArrHeights = new ArrayList<Integer>();
        ArrayList<Integer> leftArrY = new ArrayList<Integer>();
        ArrayList<Integer> rightArrHeights = new ArrayList<Integer>();
        ArrayList<Integer> rightArrY = new ArrayList<Integer>();

        for (int i = 0; i < n1; i++) {
            leftArrHeights.add(i, barCollection.getBars().get(i + l).getHeight());
            leftArrY.add(i, barCollection.getBars().get(i + l).getY());
        }
        for (int j = 0; j < n2; j++) {
            rightArrHeights.add(j, barCollection.getBars().get(m + j + 1).getHeight());
            rightArrY.add(j, barCollection.getBars().get(m + j + 1).getY());
        }

        int i = 0;
        int j = 0;

        int k = l;

        while (i < n1 && j < n2) {
            barCollection.repaint(sortVisualizer);
            if (leftArrHeights.get(i) <= rightArrHeights.get(j)) {
                barCollection.getBars().get(k).setColor(Color.ORANGE);
                barCollection.getBars().get(k).setHeight(leftArrHeights.get(i));
                barCollection.getBars().get(k).setY(leftArrY.get(i));
                i++;
            } else {
                barCollection.getBars().get(k).setColor(Color.ORANGE);
                barCollection.getBars().get(k).setHeight(rightArrHeights.get(j));
                barCollection.getBars().get(k).setY(rightArrY.get(j));
                j++;
            }
            k++;
            this.numComparisons++;
            barCollection.repaint(sortVisualizer);
            barCollection.changeCollectionColor(Color.BLACK);
        }

        while (i < n1) {
            barCollection.repaint(sortVisualizer);
            barCollection.getBars().get(k).setColor(Color.ORANGE);
            barCollection.getBars().get(k).setHeight(leftArrHeights.get(i));
            barCollection.getBars().get(k).setY(leftArrY.get(i));
            i++;
            k++;
            this.numComparisons++;
            barCollection.repaint(sortVisualizer);
            barCollection.changeCollectionColor(Color.BLACK);
        }

        while (j < n2) {
            barCollection.repaint(sortVisualizer);
            barCollection.getBars().get(k).setColor(Color.ORANGE);
            barCollection.getBars().get(k).setHeight(rightArrHeights.get(j));
            barCollection.getBars().get(k).setY(rightArrY.get(j));
            j++;
            k++;
            this.numComparisons++;
            barCollection.repaint(sortVisualizer);
            barCollection.changeCollectionColor(Color.BLACK);
        }
    }   

    public void mergeSort(SortVis sortVisualizer, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(sortVisualizer, l, m);
            mergeSort(sortVisualizer, m + 1, r);
            try {
                merge(sortVisualizer, l, m, r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
