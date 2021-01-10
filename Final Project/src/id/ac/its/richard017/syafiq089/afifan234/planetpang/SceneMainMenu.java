package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class SceneMainMenu extends Scene {
	
	private Image backgroundMenu;
	//private Image buttonStart;
	//private Image buttonHighscore;
	//private Image buttonExit;
	//private Image buttonCredits;
	//private Image arrowUp;
	//private Image arrowLeft;
	//private Image arrowRight;
	//private Image arrowDown;

	private final Font small = new Font("AgencyFB", Font.BOLD, 16);
	private final Font medium = new Font("AgencyFB", Font.BOLD, 42);
	private final Font big = new Font("AgencyFB", Font.BOLD, 54);
	
	public SceneMainMenu() {
		super(480, 640);
		
		backgroundMenu = AssetManager.BACKGROUND_MENU; 
//		buttonStart = AssetManager.BUTTON_START;
//		buttonExit = AssetManager.BUTTON_EXIT;
//		buttonHighscore = AssetManager.BUTTON_HIGHSCORE;
//		buttonCredits = AssetManager.BUTTON_CREDITS;
//		arrowUp = AssetManager.ARROW_UP;
//		arrowDown = AssetManager.ARROW_DOWN;
//		arrowLeft = AssetManager.ARROW_LEFT;
//		arrowRight = AssetManager.ARROW_RIGHT;		
		
		addKeyListener(new TAdapter());
	}
	
	@Override
	public void drawObjects(Graphics g) {
		
		Button start = new Button (AssetManager.BUTTON_START, AssetManager.START_HOVER, AssetManager.START_PRESSED, 183,235);
		Button highscore = new Button (AssetManager.BUTTON_HIGHSCORE, AssetManager.HIGHSCORE_HOVER, AssetManager.HIGHSCORE_PRESSED, 183,315);
		Button achievement = new Button ();
		Button credits = new Button (AssetManager.BUTTON_CREDITS, AssetManager.CREDITS_HOVER, AssetManager.CREDITS_PRESSED, 183,475);
		Button exit = new Button (AssetManager.BUTTON_EXIT, AssetManager.EXIT_HOVER, AssetManager.EXIT_PRESSED, 183,555);
		
		g.drawImage(backgroundMenu, 0, 0, this);
		
		g.drawImage(start.getImage(), start.getPosX(), start.getPosY(), this);
		g.drawImage(highscore.getImage(), highscore.getPosX(), highscore.getPosY(), this);
	//	g.drawImage(achievement.getImage(), achievement.getPosX(), achievement.getPosY(), this);
		g.drawImage(credits.getImage(), credits.getPosX(), credits.getPosY(), this);
		g.drawImage(exit.getImage(), exit.getPosX(), exit.getPosY(), this);			
		
//		g.drawImage(arrowUp,232,215,this);
//		g.drawImage(buttonStart,183,235,this);
//		g.drawImage(arrowLeft,0,399,this);
//		g.drawImage(buttonCredits,15,383,this);
//		g.drawImage(arrowRight,454,399,this);
//		g.drawImage(buttonHighscore,345,383,this);
//		g.drawImage(arrowDown,232,616,this);
//		g.drawImage(buttonExit,183,560,this);
		DrawText(g, "Welcome to", medium, 125, 100);
		
	}
	
	public void DrawText(Graphics g, String msg, int id, int posX, int posY) {
		if (id == 0) {
			g.setFont(small);
		} else if (id == 1){
			g.setFont(medium);
		} else {
			g.setFont(big);
		}
		
		g.setColor(Color.white);
		g.drawString(msg, posX, posY);
	}
	
	public void DrawText(Graphics g, String msg, Font id, int posX, int posY) {
		g.setFont(id);
		
		g.setColor(Color.white);
		g.drawString(msg, posX, posY);
	}
	
	private class TAdapter extends KeyAdapter {
		private boolean back = false;
		
		@Override
	    public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
	        if (key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER) {
	        	back = false;
	        }
	    }
		
		@Override
	    public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (!back && (key == KeyEvent.VK_UP)) {
				SceneManager.LoadGameplayScene();
	        	back = true;
	        } else if (!back && (key == KeyEvent.VK_RIGHT)) {
				SceneManager.LoadHighscoreScene();
	        	back = true;
	        } else if (!back && (key == KeyEvent.VK_DOWN)) {
				System.exit(0);
	        } else if (!back && (key == KeyEvent.VK_LEFT)) {
	        	SceneManager.LoadCreditsScene();
	        	back = true;
	        }
	    }
	}
}
