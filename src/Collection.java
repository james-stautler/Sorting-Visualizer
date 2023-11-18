import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Collection {


    public final int SCREEN_HEIGHT = 800;
    public final int SCREEN_WIDTH = 1200;

    public final int MIN_HEIGHT = 50;
    public final int MAX_HEIGHT = 700;

    public ArrayList<Bar> bars;

    public Collection() {
        bars = new ArrayList<Bar>();
    }
    
    // Generate n random bars; make a divisor of SCREEN_WIDTH
    public Collection(int n) {
        bars = new ArrayList<Bar>();
        int width = SCREEN_WIDTH / n;
        for (int i = 0; i < n; i++) {
            int height = getRandomNumber(MIN_HEIGHT, MAX_HEIGHT + 1);
            Bar bar = new Bar(i * width, SCREEN_HEIGHT - height, width, height, Color.BLACK);
            bars.add(bar);
        }
    }

    // [min, max)
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max-min)) + min);
    }

    public void drawCollection(Graphics g) {
        if (this.bars == null) {
            return;
        }
        for (int i = 0; i < bars.size(); i++) {
            bars.get(i).drawBar(g);
        }
    }

    public ArrayList<Bar> getBars() {
        return this.bars;
    }

    public void changeCollectionColor(Color color) {
        for (int i = 0; i < bars.size(); i++) {
            bars.get(i).setColor(color);
        }
    }

    public void swap(int index1, int index2) {
        int height1 = bars.get(index1).getHeight();
        int height2 = bars.get(index2).getHeight();
        int y1 = bars.get(index1).getY();
        int y2 = bars.get(index2).getY();

        bars.get(index1).setHeight(height2);
        bars.get(index1).setY(y2);
        bars.get(index2).setHeight(height1);
        bars.get(index2).setY(y1);
    }

    public void printHeights() {
        for (int i = 0; i < bars.size(); i++) {
            System.out.print(bars.get(i).getHeight() + ", ");
        }
        System.out.println();
    }

    public void repaint(SortVis sortVisualizer) {
        sortVisualizer.paintImmediately(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        for (int i = 0; i < bars.size(); i++) {
            Bar bar = bars.get(i);
            sortVisualizer.paintImmediately(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        }
    }
}
