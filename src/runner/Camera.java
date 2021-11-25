package runner;

public class Camera {
    private double x;
    private double y;
    private double km=1;
    private double fm=1.2;
    private double vx=0;
    private double ax=-300;
    private long past=50;

    public Camera(double x,double y){
        this.x=x;
        this.y=y;
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

    public void update(long now,double xhero){
        long dt=now-past;
        ax=km*(xhero-x)-fm*vx;
        double dvx=ax*dt;
        double dx=vx*dt;
        x+=dx;
        vx+=dvx;
        past=now;
    }

    @Override
    public String toString() {
        return "X: " + x + '\'' +
                ", Y: " + y + '\'';

    }
}
