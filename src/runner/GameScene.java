package runner;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    private staticThing right;
    private staticThing left;
    private Hero hero;
    private staticThing heart;
    private int numberOfLives=3;
    private int updateCounter=0;
    private Camera camera=new Camera(300,300);
    private Enemy enemy;

    public GameScene(Pane pane, double v, double v1) {
        super(pane, v, v1);
        this.background();
        this.placeHero();
        this.placeEnemy();
        this.placeHearts();
        this.display(pane);
        timer.start();
        this.setOnMouseClicked( (event)->{
            System.out.println("Jump");
            hero.setAttitude("jump up");
        });
    }



    public void background(){
         left=new staticThing(0,0,0,0,800,400,"file:desert.png");
         right=new staticThing(800,0,0,0,800,400,"file:desert.png");
    }
    public void placeHero(){
        hero=new Hero();
    }
    public void placeHearts(){
        heart=new staticThing(20,10,32*(3-numberOfLives),0,3*32,32,"file:life.png");
    }

    public void placeEnemy(){
        enemy=new Enemy();
    }

    public void display(Pane pane){
        pane.getChildren().add(right.getImageView());
        pane.getChildren().add(left.getImageView());
        pane.getChildren().add(hero.getImageView());
        pane.getChildren().add(heart.getImageView());
        pane.getChildren().add(enemy.getImageView());
    }



    public void update(long time){
        updateCounter=(updateCounter+10)%800;
        left.getImageView().setViewport(new Rectangle2D(updateCounter, 0,800-updateCounter,400));
        right.getImageView().setViewport(new Rectangle2D(right.getX(), 0, updateCounter,400));
        right.getImageView().setX(800-updateCounter);

        heart.getImageView().setViewport(new Rectangle2D(32*(3-numberOfLives),0,3*32,32));
    }


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long time) {
            hero.update(time);
            camera.update(time,hero.getX());
            hero.setX(hero.getX()-camera.getDx());
            update(time);
            enemy.update(time);
        }
    };

}
