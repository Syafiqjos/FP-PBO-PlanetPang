package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.*;
import java.awt.event.*;

public class SceneSetting extends Scene {
	private Image backgroundSpace;
	
	private Image arrowLeft1, arrowLeft2;
	private Image arrowRight1, arrowRight2;
	
	private final Font small = new Font("AgencyFB", Font.BOLD, 16);
	private final Font medium = new Font("AgencyFB", Font.BOLD, 32);
	private final Font big = new Font("AgencyFB", Font.BOLD, 46);
	
	public SceneSetting() {
		super (480, 640);
		
		backgroundSpace = AssetManager.BACKGROUND_SPACE;
		
		arrowLeft1 = arrowLeft2 = AssetManager.ARROW_LEFT;
		arrowRight1 = arrowRight2 = AssetManager.ARROW_RIGHT;
		
		addKeyListener(new TAdapter());	
	}
	
	@Override
	public void drawObjects(Graphics g) {
		g.drawImage(backgroundSpace, 0, 0, this);
		
		DrawText(g, "SETTING", big, 140, 140);
		
		
		g.drawImage(arrowLeft1,145,254,this);
		g.drawImage(arrowRight1,319,254,this);
		
		g.drawImage(arrowLeft2,145,369,this);
		g.drawImage(arrowRight2,319,369,this);
		
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(184,548, 120, 40);
		DrawText(g, "Apply", medium, 200, 578);
		
	}
	
	public void DrawText(Graphics g, String msg, int id, int posX, int posY) {
		if (id == 0) {
			g.setFont(small);
		} else if (id == 1){
			g.setFont(medium);
		} else {
			g.setFont(big);
		}
		
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
