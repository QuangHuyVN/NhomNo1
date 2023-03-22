import Global.Configuration;

import java.io.InputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AppleWorm extends JPanel implements ActionListener{
    private JLabel textField;
    private JButton startButton, exitButton;
    public AppleWorm() {
        setPreferredSize(new Dimension(400, 200));
        setLayout(new FlowLayout());

        textField = new JLabel("Home");
        startButton = new JButton("Start");
        exitButton = new JButton("Exit");

        startButton.addActionListener(this);
        exitButton.addActionListener(this);

        add(textField);
        add(startButton);
        add(exitButton);
    }
    public static void main(String [] args){
        JFrame frame = new JFrame("My Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AppleWorm());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void playGame(String mapnum){
        //try{
        String map = "Levels/Level"+mapnum+".txt";
        System.out.println(map);
        String newmap = "Levels/Levels.txt";
        InputStream in = Configuration.charge(map);
        LevelLector l = new LevelLector(in);
        Game game = new Game(l);
        GraphicInterface.start(game);

//        }catch (Exception e){
//            System.err.println("Something went wrong! " + e);
//        }
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            playGame("1");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
}