package runner;

import javafx.geometry.Rectangle2D;

public class Enemy extends AnimatedThing{
    private long past=0;
    private double wait;

    public Enemy() {
        super(200, 250, "run", 33, 0, 5, 50, 50, 5, 0, "file:Hyena_walk.png");
    }

    public void update(long time){
        wait=(time-past)*Math.pow(10,-9);
        if (wait>0.1) {
            if (index > maxIndex) {
                index = 0;
            } else {
                index++;
            }
            past=time;
            sprite.setViewport(new Rectangle2D(index*offsetx,0,w,h));
        }
    }
}
