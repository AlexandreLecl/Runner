package runner;

public class Camera {
    private double x;
    private double y;
    private double km=1;
    private double fm=1.2;
    private double vx=0;
    private double ax=-300;
    private long past=0;
    private double dt=0;
    private double dx=0;

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

    public double getDx() {
        return dx;
    }

    public double getDt() {
        return dt;
    }

    public void update(long now, double xhero){
        dt = (now - past) * Math.pow(10, -9);
        if(dt<1) {
            ax = km * (xhero - x) - fm * vx;
            dx = vx * dt;
            x += dx;
            vx += ax * dt;
        }
        past=now;
    }

    @Override
    public String toString() {
        return "X: " + x + '\'' +
                ", Y: " + y + '\'';
    }
}
