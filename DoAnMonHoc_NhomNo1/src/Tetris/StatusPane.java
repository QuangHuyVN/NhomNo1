/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tetris;

/**
 *
 * @author Hải Đoàn
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class StatusPane extends JPanel implements ActionListener{
	Application myApp;
	OptionPane option;
	JLabel score;
	public StatusPane(Application app)
	{
		myApp = app;
		setPreferredSize(new Dimension(120, 400));
		setBorder(BorderFactory.createEtchedBorder(Color.red, Color.blue));
		initializeComponents();
	}
	private void initializeComponents() {
		setLayout(new GridLayout( 10, 1));
		
		option = new OptionPane(myApp);
		JButton butStart = new JButton("Start Game");
		butStart.setPreferredSize(new Dimension(100, 40));
		butStart.addActionListener(this);
		this.add(butStart);
		JButton butOption = new JButton("Setting");
		butOption.setPreferredSize(new Dimension(100, 40));
		butOption.addActionListener(this);
		this.add(butOption);
		score = new JLabel("Score: 0");
		this.add(score);
	}
	
	public void scored(int score)
	{
		this.score.setText("Score: "  +   Integer.toString(score));
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Start Game"){
			myApp.tetris.board.start();
		}
		else
		{
			myApp.tetris.board.stop();
			option.setVisible(true);
		}
	}
}

