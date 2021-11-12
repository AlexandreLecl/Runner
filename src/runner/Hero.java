package runner;

public class Hero extends AnimatedThing{
    private Hero hero;
    public Hero() {
        super(20, 250, 0, 33, 6, 75, 100, 35, 160,100,"C:\\Users\\alex_\\Documents\\cours\\ENSEA\\2ème année-ENSEA\\Java\\runner\\heros.png");
    }

    public void update(long time){
        hero.setIndex(hero.getIndex()+1);
    }

}
