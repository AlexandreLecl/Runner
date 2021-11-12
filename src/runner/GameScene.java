package runner;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;

public class GameScene extends Scene {
    private Camera camera;
    private staticThing right;
    private staticThing left;
    private Hero hero;
    private staticThing heart;
    private int numberOfLives=3;
    public GameScene(Pane pane, double v, double v1) {
        super(pane, v, v1);
        this.background();
        this.placeHero();
        this.placeHearts();
        this.display(pane);
        timer.start();
    }

    public void background(){
         left=new staticThing(0,0,500,0,300,400,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\desert.png");
         right=new staticThing(300,0,0,200,300,0,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\desert.png");
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
        left.setX(left.getX()+);
    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            hero.update(time);
            camera.update(time);
            gameScene.update(time);
            System.out.println(time);
        }
    };

}
