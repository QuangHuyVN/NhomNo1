package Mines;


import Mines.Board;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.Random;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;

public class Mines extends JFrame {

 	JMenuBar menuBar;
    JMenu menuFile;   
    Board board;
	JMenuItem menuFileNew,menuFileOpen,menuFileSave,menuFileSaveAs,menuFileExit;
	
    private final int WIDTH = 500;
    private final int HEIGHT = 580;

    private JLabel statusbar;
    
    public Mines() {

		menuBar = new JMenuBar();
        menuFile = new JMenu("File");
        
		menuFileNew = new JMenuItem("New");
        menuFileOpen = new JMenuItem("Open");
        menuFileSave = new JMenuItem("Save");
        menuFileSaveAs = new JMenuItem("Save As");
        menuFileExit = new JMenuItem("Exit");
        
        menuFile.setMnemonic('F');
        menuFileNew.setMnemonic('N');
        menuFileOpen.setMnemonic('O');
        menuFileSave.setMnemonic('S');
        menuFileSaveAs.setMnemonic('A');
        menuFileExit.setMnemonic('E');
		
		menuFile.add(menuFileNew);
        menuFile.add(menuFileOpen);
        menuFile.add(menuFileSave);
        menuFile.add(menuFileSaveAs);
        menuFile.add(menuFileExit);
        
        menuFileExit.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Mines.this.windowClosed();
                }
            }
        ); 
        	
        	
        menuFileNew.addActionListener
        (
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Mines.this.newGame();
                }
            }
        ); 	
        
        menuBar.add(menuFile);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Minesweeper");

        statusbar = new JLabel("");
        add(statusbar, BorderLayout.SOUTH);
        board = new Board(statusbar);
        add(board);

        setResizable(false);
        setVisible(true);
        setJMenuBar(menuBar);
    }
    
     protected void windowClosed() {
    	
        System.exit(0);
    }

    public void newGame() {

        board.newGame();
        board.repaint();
    }
    
    public static void main(String[] args) {
        new Mines();
    }
}

