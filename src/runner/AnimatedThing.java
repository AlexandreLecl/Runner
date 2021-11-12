package runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private ImageView sprite;
    private int attitude;
    private int index;
    private int duration;
    private int maxIndex;
    private double w;
    private double h;
    private double offsetx;
    private double offsety;


    public AnimatedThing(double x,double y,int attitude,int duration,int maxIndex,double w,double h,double offsetx,double offsety,String fileName){
        for (index=0;index<maxIndex;index++){
            Image spriteSheet = new Image(fileName);
            sprite = new ImageView(spriteSheet);
            sprite.setViewport(new Rectangle2D(index*offsetx,attitude*offsety,w,h));
            sprite.setX(x);
            sprite.setY(y);
            //Thread.sleep(duration);
            //duration is in milliseconds
        }
    }

    public ImageView getImageView() {
        return sprite;
    }

    public AnimatedThing update(AnimatedThing animatedThing) {

    }
}
