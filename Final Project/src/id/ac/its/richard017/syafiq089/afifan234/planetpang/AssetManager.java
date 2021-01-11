package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Image;

import javax.swing.ImageIcon;

public class AssetManager {
	public static Image PLANET_LEFT;
	public static Image PLANET_RIGHT;
	
	public static Image BACKGROUND_SPACE;
	public static Image BACKGROUND_MENU;
	
	public static Image BUTTON_START, 
						START_HOVER, 
						START_PRESSED;

	public static Image BUTTON_CREDITS, 
						CREDITS_HOVER, 
						CREDITS_PRESSED;
		
	public static Image BUTTON_EXIT, 
						EXIT_HOVER, 
						EXIT_PRESSED;
	
	public static Image BUTTON_HIGHSCORE, 
						HIGHSCORE_HOVER, 
						HIGHSCORE_PRESSED;
	
	public static Image BUTTON_ACHIEVEMENT,
						ACHIEVEMENT_HOVER,
						ACHIEVEMENT_PRESSED;
	
	public static Image ARROW_UP;
	public static Image ARROW_DOWN;
	public static Image ARROW_LEFT;
	public static Image ARROW_RIGHT;
	
	public static Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        return ii.getImage();
    }
	
	public static void LoadAssets() {
		PLANET_LEFT = loadImage("sprite/Planet1.png");
		PLANET_RIGHT = loadImage("sprite/Planet2.png");
		
		BACKGROUND_SPACE = loadImage("sprite/BackgroundSpace.png");
		BACKGROUND_MENU = loadImage("sprite/MainMenuBg.png");
		
		BUTTON_START = loadImage("sprite/Button_Start_Normal.png");
		START_HOVER = loadImage("sprite/Button_Start_MouseEnter.png");
		START_PRESSED = loadImage("sprite/Button_Start_MouseClick.png");
		
		BUTTON_CREDITS = loadImage("sprite/Button_Credits_Normal.png");
		CREDITS_HOVER = loadImage("sprite/Button_Credits_MouseEnter.png");
		CREDITS_PRESSED = loadImage("sprite/Button_Credits_MouseClick.png");
		
		BUTTON_EXIT = loadImage("sprite/Button_Exit_Normal.png");
		EXIT_HOVER = loadImage("sprite/Button_Exit_MouseEnter.png");
		EXIT_PRESSED = loadImage("sprite/Button_Exit_MouseClick.png");
		
		BUTTON_HIGHSCORE = loadImage("sprite/Button_Highscore_Normal.png");
		HIGHSCORE_HOVER = loadImage("sprite/Button_Highscore_MouseEnter.png");
		HIGHSCORE_PRESSED = loadImage("sprite/Button_Highscore_MouseClick.png");
		
		BUTTON_ACHIEVEMENT = loadImage("sprite/Button_Achievement_Normal.png");
		ACHIEVEMENT_HOVER = loadImage("sprite/Button_Achievement_MouseEnter.png");
		ACHIEVEMENT_PRESSED = loadImage("sprite/Button_Achievement_MouseClick.png");
		
		ARROW_UP = loadImage("sprite/Arrow_Up.png");
		ARROW_DOWN = loadImage("sprite/Arrow_Down.png");
		ARROW_LEFT = loadImage("sprite/Arrow_Left.png");
		ARROW_RIGHT = loadImage("sprite/Arrow_Right.png");
	}
}
