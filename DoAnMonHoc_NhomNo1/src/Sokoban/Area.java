/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sokoban;

/**
 *
 * @author Hải Đoàn
 */
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Area extends Actor {

    public Area(int x, int y) {
        super(x, y);

        ImageIcon iia = new ImageIcon("area.png");
        Image image = iia.getImage();
        this.setImage(image);
    }
}

