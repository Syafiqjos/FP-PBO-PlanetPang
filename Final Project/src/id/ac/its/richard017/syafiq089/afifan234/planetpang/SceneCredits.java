package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SceneCredits extends Scene {
	
	private Image backgroundSpace;
	
	private final Font small = new Font("AgencyFB", Font.BOLD, 16);
	private final Font medium = new Font("AgencyFB", Font.BOLD, 42);
	private final Font big = new Font("AgencyFB", Font.BOLD, 64);
	
	public SceneCredits() {
		super(480, 640);
		
		backgroundSpace = AssetManager.BACKGROUND_SPACE; 
		
		addKeyListener(new TAdapter());
	}
	
	@Override
	public void drawObjects(Graphics g) {
		g.drawImage(backgroundSpace, 0, 0, this);
		
		DrawText(g, "CREDITS :", 2, 20, 160);
		DrawText(g, "Planet Pang", 1, 20, 220);
		DrawText(g, "Made by Group Panjang", 0, 20, 250);
		DrawText(g, "- Richard Asmarakandi (05111940000017)", 0, 20, 280);
		DrawText(g, "- Ahmad Syafiq Aqil Wafi (05111940000089)", 0, 20, 310);
		DrawText(g, "- Afifan Syafaqi Yahya (05111940000234)", 0, 20, 340);
		
		DrawText(g, "[ Press Backspace or Enter to return to Main Menu ]", 0, 20, 470);
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
			if (!back && (key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_ENTER)) {
				SceneManager.LoadMainMenuScene();
	        	back = true;
	        }
	    }
	}
}
