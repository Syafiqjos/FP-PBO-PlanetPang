package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Image;

import javax.swing.ImageIcon;

public class AssetManager {
	public static Image PLANET_LEFT;
	public static Image PLANET_RIGHT;
	public static Image BACKGROUND_SPACE;
	public static Image BACKGROUND_MENU;
	public static Image BUTTON_START;
	public static Image BUTTON_CREDITS;
	public static Image BUTTON_EXIT;
	public static Image BUTTON_HIGHSCORE;
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
		BUTTON_CREDITS = loadImage("sprite/Button_Credits_Normal.png");
		BUTTON_EXIT = loadImage("sprite/Button_Exit_Normal.png");
		BUTTON_HIGHSCORE = loadImage("sprite/Button_Highscore_Normal.png");
		ARROW_UP = loadImage("sprite/Arrow_Up.png");
		ARROW_DOWN = loadImage("sprite/Arrow_Down.png");
		ARROW_LEFT = loadImage("sprite/Arrow_Left.png");
		ARROW_RIGHT = loadImage("sprite/Arrow_Right.png");
	}
}
