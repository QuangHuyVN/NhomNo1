import Global.Configuration;

public class Game {
    Level current;
    LevelLector lector;

    public Game(LevelLector l){
        lector = l;
        nextLevel();
    }

    public Level level(){
        return current;
    }

    public boolean nextLevel(){
        current = lector.readNextLevel();
        return current != null;
    }

    public int playerL(){
        return current.playerL();
    }

    public int playerC(){
        return current.playerC();
    }

    public void move(int l, int c){
        if(!current.move(l,c))
            Configuration.instance().logger().info("Cannot move!");
        if(current.isFinished())
            if(!nextLevel())
                System.exit(0);
    }
}