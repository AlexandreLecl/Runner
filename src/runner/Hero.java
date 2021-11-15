package runner;

import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    public Hero() {
        super(20, 250, 1, 33, 1, 5, 80, 100, 85,100,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\heros.png");
    }

    public void update(long time){
        if (index>maxIndex){
            index=0;
        }else{
            index++;
        }
        sprite.setViewport(new Rectangle2D(index*offsetx,attitude*offsety,w,h));
    }
}
