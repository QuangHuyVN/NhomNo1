import Global.Configuration;

import java.io.InputStream;

public class AppleWorm {
    public static void main(String [] args){
        try{
            InputStream in = Configuration.charge("Levels/Levels.txt");
            LevelLector l = new LevelLector(in);
            Game game = new Game(l);
            GraphicInterface.start(game);
        }catch (Exception e){
            System.err.println("Something went wrong! " + e);
        }
    }
}