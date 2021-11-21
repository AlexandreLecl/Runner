package runner;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    private Camera camera;
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
         left=new staticThing(0,0,500,0,300,400,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\desert.png");
         right=new staticThing(300,0,0,0,300,400,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\desert.png");
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
        if (updateCounter>=300){
            updateCounter=0;
        }else{
            updateCounter+=10;
        }
        //left.setX(500+updateCounter);
        //left.setW(300-updateCounter);
        left.getImageView().setX(0-updateCounter);
        //right.setW(300+updateCounter);
        right.getImageView().setX(300-updateCounter);

        //left.getImageView().setViewport(new Rectangle2D(left.getX(), left.getY(), left.getW(),left.getH()));
        //right.getImageView().setViewport(new Rectangle2D(right.getX(), right.getY(), right.getW(),right.getH()));
    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            hero.update(time);
            //camera.update(time);
            update(time);
        }
    };

}
