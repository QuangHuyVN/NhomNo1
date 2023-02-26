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
import javax.swing.ImageIcon;


public class Shot extends Sprite {

    private String shot = "spacepix/shot.png";
    private final int H_SPACE = 6;
    private final int V_SPACE = 1;

    public Shot() {
    }

    public Shot(int x, int y) {

        ImageIcon ii = new ImageIcon(shot);
        setImage(ii.getImage());
        setX(x + H_SPACE);
        setY(y - V_SPACE);
    }
}

