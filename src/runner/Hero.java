package runner;

import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    long past=0;
    double wait;
    public Hero() {
        super(150, 250, 1, 33, 1, 4, 80, 100, 85,100,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\heros.png");
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
        }
        sprite.setViewport(new Rectangle2D(index*offsetx,attitude*offsety,w,h));
        sprite.setX(x);
        //sprite.setY(y);

    }
}
