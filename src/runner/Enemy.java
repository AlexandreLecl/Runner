package runner;

import javafx.geometry.Rectangle2D;

public class Enemy extends AnimatedThing{
    private long past=0;
    private double wait;

    public Enemy() {
        super(500, 290, "run", 33, 1, 2, 30, 50, 48, 0, "file:Ghost_Sprites.png");
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
            this.sprite.setViewport(new Rectangle2D(290+index*offsetx,0,w,h));
        }
    }
}
