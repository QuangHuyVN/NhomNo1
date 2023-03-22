import javax.swing.*;
import java.awt.*;

public class GraphicInterface implements Runnable{
    Game game;
    boolean fullScreen;
    JFrame frame;
    GraphicLevel gl;

    public GraphicInterface(Game g){
        game = g;
    }

    public static void start(Game g){
        SwingUtilities.invokeLater(new GraphicInterface(g));
    }

    public void run() {
        frame = new JFrame("AppleWorm by No1");
        gl = new GraphicLevel(game);
        frame.add(gl);
        gl.addMouseListener(new MouseEvents(gl, game));
        frame.addKeyListener(new KeyboardEvents(this, game));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setJMenuBar(null);
    }
        /*JMenuBar menubar = new JMenuBar();
        JMenu menu;
        JMenuItem menuitem;

        this.setJMenuBar(menubar);
        menu = new JMenu("Game");
        menu.setMnemonic(KeyEvent.VK_G);
        menuitem = new JMenuItem("New Game");
        menuitem.setMnemonic(KeyEvent.VK_N);
        menuitem.addActionListener(new Sokoban.MenuHandler(this));
        menu.add(menuitem);
        menu.addSeparator();
        menuitem = new JMenuItem("Exit");
        menuitem.setMnemonic(KeyEvent.VK_X);
        menuitem.addActionListener(new Sokoban.MenuHandler(this));
        menu.add(menuitem);
        menubar.add(menu);
    }

    public class MenuHandler implements ActionListener
    {
        Sokoban ter;
        public MenuHandler(Sokoban ter)
        {
            this.ter = ter;
        }
        public void actionPerformed(ActionEvent e) {
            String s = e.getActionCommand();
            if(s == "New Game")
            {

            }
            else if(s == "Exit")
            {
                Level level = new Level();
                level.setVisible(true);
                ter.dispose();
            }
        }
    }*/
    public void toggleFullScreen(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        if(fullScreen){
            device.setFullScreenWindow(null);
            fullScreen = false;
        }else{
            device.setFullScreenWindow(frame);
            fullScreen = true;
        }
    }

    public void repaint(){
        gl.repaint();
    }
}
