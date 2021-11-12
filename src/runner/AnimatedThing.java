package runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private ImageView sprite;
    private int attitude;
    private int index=1;
    private int duration;
    private int maxIndex;
    private double w;
    private double h;
    private double offsetx;
    private double offsety;


    public AnimatedThing(double x,double y,int attitude,int duration,int index,int maxIndex,double w,double h,double offsetx,double offsety,String fileName){
        if (index>=maxIndex){
            index=0;
        }
            Image spriteSheet = new Image(fileName);
            sprite = new ImageView(spriteSheet);
            sprite.setViewport(new Rectangle2D(index*offsetx,attitude*offsety,w,h));
            sprite.setX(x);
            sprite.setY(y);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ImageView getImageView() {
        return sprite;
    }


    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getOffsetx() {
        return offsetx;
    }

    public void setOffsetx(double offsetx) {
        this.offsetx = offsetx;
    }

    public double getOffsety() {
        return offsety;
    }

    public void setOffsety(double offsety) {
        this.offsety = offsety;
    }
}
