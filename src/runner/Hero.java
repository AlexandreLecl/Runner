package runner;

import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing{
    private long past=0;
    private double wait;
    private double vy=0;
    private double ay=170;
    public Hero() {
        super(0, 250, "run", 33, 1, 4, 80, 100, 85,100,"file:heros.png");
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
        if (attitude.equals("run")){
            sprite.setViewport(new Rectangle2D(index*offsetx,0,w,h));
            setMaxIndex(4);
        }
        if (attitude.equals("jump up")){
            sprite.setViewport(new Rectangle2D(0,160,w,h));
            setMaxIndex(0);
            ay -=120*wait;
            vy+=ay*wait;
            y-=vy*wait;
            if (vy<0){
                attitude="jump down";
            }
            if (y>250){
                y=250;
                attitude="run";
                ay=170;
                vy=0;
            }
        }
        if (attitude.equals("jump down")){
            sprite.setViewport(new Rectangle2D(offsetx,160,w,h));
            ay -=120*wait;
            vy+=ay*wait;
            y-=vy*wait;
            if (y>250){
                y=250;
                attitude="run";
                ay=170;
                vy=0;
            }
        }
        sprite.setX(x);
        sprite.setY(y);
    }
}
