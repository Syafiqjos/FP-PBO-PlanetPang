package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SceneCredits extends Scene {
	
	private Image backgroundSpace;
	
	private final Font small = new Font("AgencyFB", Font.BOLD, 24);
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
