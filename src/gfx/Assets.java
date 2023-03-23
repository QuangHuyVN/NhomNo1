package gfx;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import appleworm.Level;

public class Assets {
	
	public static Image playerLeft, playerBack, playerRight, PlayerFront;
	
	public static Image floor, floor2, wall, boxOn, boxOff, spot, outline, outline2;
	
	public static Font font48;
	public static Font font30;
	public static Font font22;
	
	public static void init()
	{
		playerLeft = loadImage("/player/left.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		playerBack = loadImage("/player/back.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		PlayerFront = loadImage("/player/front.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		playerRight = loadImage("/player/right.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		
		floor = loadImage("/blocks/ground.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		floor2 = loadImage("/blocks/ground2.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		wall = loadImage("/player/Wall1.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		boxOn = loadImage("/player/AppleGoat.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		boxOff = loadImage("/player/Apple.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		spot = loadImage("/player/Goal.png").getScaledInstance(Level.TILESIZE, Level.TILESIZE, BufferedImage.SCALE_DEFAULT);
		outline = loadImage("/blocks/outline.png").getScaledInstance(64, 64, BufferedImage.SCALE_DEFAULT);
		outline2 = loadImage("/blocks/outline2.png").getScaledInstance(64, 64, BufferedImage.SCALE_DEFAULT);
		
		font48 = loadFont("res/fonts/LuckiestGuy-Regular.ttf", 48);
		font22 = loadFont("res/fonts/LuckiestGuy-Regular.ttf", 22);
		font30 = loadFont("res/fonts/LuckiestGuy-Regular.ttf", 30);
		
	}
	
	public static BufferedImage loadImage(String path)
	{
		try {
			return ImageIO.read(Assets.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Font loadFont(String path, int size){
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(Font.PLAIN, size);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
