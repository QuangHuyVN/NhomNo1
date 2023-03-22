import java.io.InputStream;
import java.util.Scanner;

public class LevelLector {
    Scanner s;

    public LevelLector(InputStream in){
        s = new Scanner(in);
    }

    public Level readNextLevel(){
        Level lev = new Level();
        String line = null;
        int i = 0;
        try{
            line = s.nextLine();
        }catch (Exception e){
            return null;
        }
        while(line.length() > 0){
            if(line.charAt(0) == ';'){
                int j = 1;
                while(line.charAt(j) == ' ')
                    j++;
                lev.fixName(line.substring(j));
            }else{
                for(int j = 0; j < line.length(); j++){
                    switch (line.charAt(j)){
                        case '#':
                            lev.addWall(i, j);
                            break;
                        case '!':
                            lev.addWall2(i, j);
                            break;
                        case '@':
                            lev.addPlayer(i, j);
                            break;
                        case '$':
                            lev.addBox(i, j);
                            break;
                        case '+':
                            lev.addPlayer(i,j);
                            lev.addTarget(i,j);
                            break;
                        case '*':
                            lev.addBox(i, j);
                            lev.addTarget(i,j);
                            break;
                        case '.':
                            lev.addTarget(i, j);
                            break;
                        case ' ':
                            break;
                        default:
                            System.err.println("Invalid Character!");
                            System.exit(1);
                    }
                }
            }
            line = s.nextLine();
            i++;
        }
        return lev;
    }
}
