import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("all")
public class Collection {


    public final int SCREEN_HEIGHT = 800;
    public final int SCREEN_WIDTH = 1200;

    public final int MIN_HEIGHT = 50;
    public final int MAX_HEIGHT = 700;

    ArrayList<Bar> bars;

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
}
