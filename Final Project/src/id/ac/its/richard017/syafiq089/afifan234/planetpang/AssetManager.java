package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Image;

import javax.swing.ImageIcon;

public class AssetManager {
	public static Image PLANET_LEFT;
	public static Image PLANET_RIGHT;
	public static Image BACKGROUND_SPACE;
	
	public static Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        return ii.getImage();
    }
	
	public static void LoadAssets() {
		PLANET_LEFT = loadImage("sprite/Planet1.png");
		PLANET_RIGHT = loadImage("sprite/Planet2.png");
		BACKGROUND_SPACE = loadImage("sprite/BackgroundSpace.png");
	}
}
