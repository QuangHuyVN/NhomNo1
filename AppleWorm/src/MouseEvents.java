import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEvents extends MouseAdapter {
    GraphicLevel gl;
    Game g;

    public MouseEvents(GraphicLevel gl, Game g){
        this.gl = gl;
        this.g = g;
    }

    @Override
    public void mousePressed(MouseEvent e){
        int x = e.getX() / gl.cellWidth();
        int y = e.getY() / gl.cellHeight();

        int dX = x - g.playerC();
        int dY = y - g.playerL();
        int sum = dX + dY;
        sum = sum*sum;
        if((dX*dY ==0) && (sum==1)){
            g.move(dY,dX);
            gl.repaint();
        }
    }
}