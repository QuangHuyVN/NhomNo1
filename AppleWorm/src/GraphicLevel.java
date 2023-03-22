import Global.Configuration;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class GraphicLevel extends JComponent {
    Game game;
    Image goal, box, boxOnGoal, wall, wall2, player,floor;
    int cellWidth;
    int cellHeight;

    private Image chargeImage(String name){
        Image img = null;
        InputStream in = Configuration.charge("images/" + name + ".png");
        try{
            img = ImageIO.read(in);
        }catch (Exception e){
            Configuration.instance().logger.severe("Cannot charge the image");
            System.exit(1);
        }
        return img;
    }

    public GraphicLevel(Game g){
        goal = chargeImage("GlassGoat");
        box = chargeImage("Apple");
        boxOnGoal = chargeImage("AppleGoat");
        wall = chargeImage("Wall");
        wall2 = chargeImage("Wall2");
        player  = chargeImage("Player");
        floor = chargeImage("Glass");
        game = g;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D draw = (Graphics2D) g;

        int width = getSize().width;
        int height = getSize().height;

        draw.clearRect(0, 0, width, height);

        Level lev = game.level();
        cellWidth = width/lev.columns();
        cellHeight = height/lev.lines();

        for(int i = 0; i < lev.columns(); i++){
            for(int j = 0; j < lev.lines(); j++){
                int x = i * cellWidth;
                int y = j * cellHeight;

                if(lev.hasTarget(j,i))
                    draw.drawImage(goal,x, y, cellWidth, cellHeight, null);
                else
                    draw.drawImage(floor,x, y, cellWidth, cellHeight, null);

                if(lev.hasWall(j, i))
                    draw.drawImage(wall,x, y, cellWidth, cellHeight, null);
                else if(lev.hasWall2(j, i))
                    draw.drawImage(wall2,x, y, cellWidth, cellHeight, null);
                else if(lev.hasBox(j,i))
                    if(lev.hasTarget(j,i))
                        draw.drawImage(boxOnGoal,x, y, cellWidth, cellHeight, null);
                    else
                        draw.drawImage(box,x, y, cellWidth, cellHeight, null);
                else if(lev.hasPlayer(j,i))
                    draw.drawImage(player,x, y, cellWidth, cellHeight, null);

            }
        }
    }
    public int cellWidth(){
        return cellWidth;
    }

    public int cellHeight(){
        return cellHeight;
    }
}
