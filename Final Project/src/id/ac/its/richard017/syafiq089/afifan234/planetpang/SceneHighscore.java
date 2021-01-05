package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SceneHighscore extends Scene {
	
	private Image backgroundSpace;
	
	private final Font small = new Font("AgencyFB", Font.BOLD, 16);
	private final Font medium = new Font("AgencyFB", Font.BOLD, 42);
	private final Font big = new Font("AgencyFB", Font.BOLD, 54);
	
	public SceneHighscore() {
		super(480, 640);
		
		backgroundSpace = AssetManager.BACKGROUND_SPACE; 
		
		addKeyListener(new TAdapter());
	}
	
	@Override
	public void drawObjects(Graphics g) {
		g.drawImage(backgroundSpace, 0, 0, this);
		
		DrawText(g, "LEADERBOARD :", 2, 20, 160);
		DrawText(g, "Planet Pang", 1, 20, 220);
		
		DrawText(g, String.format("HIGHSCORE : %d", MainApp.highscoreSystem.loadHighScore()), 0, 20, 310);
		DrawText(g, String.format("SCORE : %d", GameMaster.GetScore()), 0, 20, 340);
		
		DrawText(g, "[ Press Enter to Play ]", 0, 20, 440);
		DrawText(g, "[ Press Backspace to Main Menu ]", 0, 20, 470);
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
			if (!back && (key == KeyEvent.VK_ENTER)) {
				SceneManager.LoadGameplayScene();
	        	back = true;
	        } else if (!back && (key == KeyEvent.VK_BACK_SPACE)) {
				SceneManager.LoadMainMenuScene();
	        	back = true;
	        }
	    }
	}
}
