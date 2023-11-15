
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
                    sortVisualizer.paintImmediately(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                    sortVisualizer.paintImmediately(barCollection.getBars().get(j).getX(), 
                                                    barCollection.getBars().get(j).getY(), 
                                                    barCollection.getBars().get(j).getWidth(),
                                                    barCollection.getBars().get(j).getHeight());
                    sortVisualizer.paintImmediately(barCollection.getBars().get(j+1).getX(), 
                                                    barCollection.getBars().get(j+1).getY(), 
                                                    barCollection.getBars().get(j+1).getWidth(),
                                                    barCollection.getBars().get(j+1).getHeight());
                    Thread.sleep(TIMEOUT);
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public void InsertionSort(SortVis sortVisualizer) throws InterruptedException {
        for (int i = 1; i < barCollection.getBars().size(); i++) {
            int key = barCollection.getBars().get(i).getHeight();
            int j =  i - 1;
            while (j >= 0 && barCollection.getBars().get(j).getHeight() > key) {
                barCollection.swap(j, j + 1);
                sortVisualizer.paintImmediately(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
                sortVisualizer.paintImmediately(barCollection.getBars().get(j).getX(), 
                                                barCollection.getBars().get(j).getY(), 
                                                barCollection.getBars().get(j).getWidth(),
                                                barCollection.getBars().get(j).getHeight());
                sortVisualizer.paintImmediately(barCollection.getBars().get(j+1).getX(), 
                                                barCollection.getBars().get(j+1).getY(), 
                                                barCollection.getBars().get(j+1).getWidth(),
                                                barCollection.getBars().get(j+1).getHeight());
                Thread.sleep(TIMEOUT);
                j--;
            }
            barCollection.getBars().get(j + 1).setHeight(key);
            sortVisualizer.paintImmediately(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
            sortVisualizer.paintImmediately(barCollection.getBars().get(j+1).getX(), 
                                                barCollection.getBars().get(j+1).getY(), 
                                                barCollection.getBars().get(j+1).getWidth(),
                                                barCollection.getBars().get(j+1).getHeight());
            Thread.sleep(TIMEOUT);
        }
    }
}
