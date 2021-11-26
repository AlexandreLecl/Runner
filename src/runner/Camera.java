package runner;

public class Camera {
    private double x;
    private double y;
    private double km=5;
    private double fm=35;
    private double vx=1;
    private double ax=-300;
    private long past=50;
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

    public void update(long now, double xhero){
        ax=km*(xhero-x)-fm*vx;
        double dvx=ax*dt;
        dx=vx*dt;
        x+=dx;
        vx+=dvx;
        dt=(now-past)*Math.pow(10,-9);
        past=now;
        System.out.println("dx");
        System.out.println(dx);
        System.out.println("x");
        System.out.println(x);
        System.out.println("vx");
        System.out.println(vx);
        System.out.println("ax");
        System.out.println(ax);
        System.out.println("xhero");
        System.out.println(xhero);
        System.out.println("dt");
        System.out.println(dt);
        System.out.println("\n");


    }

    @Override
    public String toString() {
        return "X: " + x + '\'' +
                ", Y: " + y + '\'';

    }
}
