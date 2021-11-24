package runner;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.geometry.Rectangle2D;

public class GameScene extends Scene {
    private Camera camera=new Camera(300,300);
    private staticThing right;
    private staticThing left;
    private Hero hero;
    private staticThing heart;
    private int numberOfLives=3;
    private int updateCounter=0;
    public GameScene(Pane pane, double v, double v1) {
        super(pane, v, v1);
        this.background();
        this.placeHero();
        this.placeHearts();
        this.display(pane);
        timer.start();
    }

    public void background(){
         left=new staticThing(0,0,0,0,800,400,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\desert.png");
         right=new staticThing(800,0,0,0,800,400,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\desert.png");
    }
    public void placeHero(){
        hero=new Hero();
    }
    public void placeHearts(){
        heart=new staticThing(20,10,32*(3-numberOfLives),0,3*32,32,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\life.png");
    }

    public void display(Pane pane){
        pane.getChildren().add(right.getImageView());
        pane.getChildren().add(left.getImageView());
        pane.getChildren().add(hero.getImageView());
        pane.getChildren().add(heart.getImageView());
    }



    public void update(long time){
        updateCounter=(updateCounter+10)%800;
        left.getImageView().setViewport(new Rectangle2D(updateCounter, 0,800-updateCounter,400));
        right.getImageView().setViewport(new Rectangle2D(right.getX(), 0, updateCounter,400));
        right.getImageView().setX(800-updateCounter);
    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            hero.update(time);
            camera.update(time,hero.getX());
            update(time);
        }
    };

}
