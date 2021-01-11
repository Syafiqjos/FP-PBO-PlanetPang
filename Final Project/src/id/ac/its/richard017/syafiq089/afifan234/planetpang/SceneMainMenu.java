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
	private Button start = new Button (AssetManager.BUTTON_START, AssetManager.START_HOVER, AssetManager.START_PRESSED, 183,240);
	private Button highscore = new Button (AssetManager.BUTTON_HIGHSCORE, AssetManager.HIGHSCORE_HOVER, AssetManager.HIGHSCORE_PRESSED, 183,315);
	private Button achievement = new Button (AssetManager.BUTTON_ACHIEVEMENT, AssetManager.ACHIEVEMENT_HOVER, AssetManager.ACHIEVEMENT_PRESSED, 179,393);
	private Button credits = new Button (AssetManager.BUTTON_CREDITS, AssetManager.CREDITS_HOVER, AssetManager.CREDITS_PRESSED, 183,475);
	private Button exit = new Button (AssetManager.BUTTON_EXIT, AssetManager.EXIT_HOVER, AssetManager.EXIT_PRESSED, 183,550);

	private final Font small = new Font("AgencyFB", Font.BOLD, 16);
	private final Font medium = new Font("AgencyFB", Font.BOLD, 42);
	private final Font big = new Font("AgencyFB", Font.BOLD, 54);

	private int selectionMenuIndex = 0;
	
	public SceneMainMenu() {
		super(480, 640);
		
		backgroundMenu = AssetManager.BACKGROUND_MENU; 
		
		addKeyListener(new TAdapter());
		
		SelectMenu();
	}
	
	@Override
	public void drawObjects(Graphics g) {		
		g.drawImage(backgroundMenu, 0, 0, this);
		
		g.drawImage(start.getCurrentImage(), start.getPosX(), start.getPosY(), this);
		g.drawImage(highscore.getCurrentImage(), highscore.getPosX(), highscore.getPosY(), this);
		g.drawImage(achievement.getCurrentImage(), achievement.getPosX(), achievement.getPosY(), this);
		g.drawImage(credits.getCurrentImage(), credits.getPosX(), credits.getPosY(), this);
		g.drawImage(exit.getCurrentImage(), exit.getPosX(), exit.getPosY(), this);			

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
	
	public void PrevMenu() {
		selectionMenuIndex--;
		if (selectionMenuIndex < 0) {
			selectionMenuIndex = 0;
		}
		SelectMenu();
	}
	
	public void NextMenu() {
		selectionMenuIndex++;
		if (selectionMenuIndex > 4) {
			selectionMenuIndex = 4;
		}
		SelectMenu();
	}
	
	public void SelectMenu() {
		SelectButton(start, selectionMenuIndex == 0);
		SelectButton(highscore, selectionMenuIndex == 1);
		SelectButton(achievement, selectionMenuIndex == 2);
		SelectButton(credits, selectionMenuIndex == 3);
		SelectButton(exit, selectionMenuIndex == 4);
	}
	
	public void SelectButton(Button button, boolean isHover) {
		if (isHover) {
			button.setCurrentImage(button.getHoverImage());
		} else {
			button.setCurrentImage(button.getImage());
		}
	}
	
	private class TAdapter extends KeyAdapter {
		private boolean back = false;
		
		@Override
	    public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
	        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP) {
	        	back = false;
	        }
	    }
		
		@Override
	    public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (!back && (key == KeyEvent.VK_DOWN)) {
				NextMenu();
	        	back = true;
	        } else if (!back && (key == KeyEvent.VK_UP)) {
				PrevMenu();
	        	back = true;
	        }
			
			if (!back && (key == KeyEvent.VK_ENTER)) {
				if (selectionMenuIndex == 0) {
					SceneManager.LoadGameplayScene();
				} else if (selectionMenuIndex == 1) {
					SceneManager.LoadHighscoreScene();
				} else if (selectionMenuIndex == 2) {
					SceneManager.LoadAchievementScene();
				} else if (selectionMenuIndex == 3) {
					SceneManager.LoadCreditsScene();
				} else if (selectionMenuIndex == 4) {
					System.exit(0);
				}
			}
	    }
	}
}
