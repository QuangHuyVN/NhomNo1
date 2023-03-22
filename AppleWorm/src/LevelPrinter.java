import java.io.OutputStream;
import java.io.PrintStream;

public class LevelPrinter {
    PrintStream p;

    public LevelPrinter(OutputStream out){
        p = new PrintStream(out);
    }

    public void printLevel(Level l){
        for(int i = 0; i < l.lines(); i++){
            int last = -1 ;
            for(int j = 0; j < l.columns(); j++)
                if(!l.isEmpty(i, j))
                    last = j;

            for(int j = 0; j < l.columns(); j++){
                if(l.hasWall(i, j))
                    p.print('#');
                else if(l.hasWall2(i, j))
                    p.print('!');
                else if (l.hasPlayer(i, j))
                    if(l.hasTarget(i, j))
                        p.print('+');
                    else
                        p.print('@');
                else if (l.hasBox(i, j))
                    if(l.hasTarget(i, j))
                        p.print('*');
                    else
                        p.print('$');
                else if(l.hasTarget(i, j))
                    p.print('.');
                else
                    p.print(' ');
            }
            p.println();
        }
        p.println("; " + l.name());
        p.println();
    }
}