import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardEvents extends KeyAdapter {
    GraphicInterface inter;
    Game g;

    public KeyboardEvents(GraphicInterface gi, Game g){
        inter = gi;
        this.g = g;
    }

    public void move(int l, int c){
        g.move(l, c);
        inter.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP :
                move(-1,0);
                break;
            case KeyEvent.VK_RIGHT :
                move(0,1);
                break;
            case KeyEvent.VK_DOWN :
                move(1,0);
                break;
            case KeyEvent.VK_LEFT :
                move(0,-1);
                break;
            case KeyEvent.VK_Q :
                System.exit(0);
                break;
            case KeyEvent.VK_ESCAPE :
                inter.toggleFullScreen();
                break;
        }
    }
}
