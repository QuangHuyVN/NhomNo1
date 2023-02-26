package Mines;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Mines_OLD extends JFrame {

    private final int WIDTH = 500;
    private final int HEIGHT = 580;

    private JLabel statusbar;
    
    public Mines_OLD() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Minesweeper");

        statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);

        add(new Board(statusbar));

        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Mines_OLD();
    }
}
