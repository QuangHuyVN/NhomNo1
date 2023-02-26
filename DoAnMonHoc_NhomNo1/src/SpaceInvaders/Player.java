/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

/**
 *
 * @author Hải Đoàn
 */
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class Player extends Sprite implements Commons{

    private final int START_Y = 280; 
    private final int START_X = 270;

    private final String player = "spacepix/player.png";
    private int width;

    public Player() {

        ImageIcon ii = new ImageIcon(player);

        width = ii.getImage().getWidth(null); 

        setImage(ii.getImage());
        setX(START_X);
        setY(START_Y);
    }

    public void act() {
        x += dx;
        if (x <= 2) 
            x = 2;
        if (x >= BOARD_WIDTH - 2*width) 
            x = BOARD_WIDTH - 2*width;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A)
        {
            dx = -2;
        }

        if (key == KeyEvent.VK_D)
        {
            dx = 2;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A)
        {
            dx = 0;
        }

        if (key == KeyEvent.VK_D)
        {
            dx = 0;
        }
    }
}

