package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SceneAchievement extends Scene{
private Image backgroundSpace;
	
	private final Font small = new Font("AgencyFB", Font.BOLD, 16);
	private final Font medium = new Font("AgencyFB", Font.BOLD, 42);
	private final Font big = new Font("AgencyFB", Font.BOLD, 54);
	AchievementSystem as = new AchievementSystem();
	
	public SceneAchievement() {
		super(480, 640);
		
		backgroundSpace = AssetManager.BACKGROUND_SPACE; 
		as.loadAchievement();
		
		addKeyListener(new TAdapter());
	}
	
	@Override
	public void drawObjects(Graphics g) {
		g.drawImage(backgroundSpace, 0, 0, this);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(10,245, 460, 340);
		
		g.setColor(Color.WHITE);
		DrawText(g, "ACHIEVEMENT :", 2, 20, 160);
		DrawText(g, "Planet Pang", 1, 20, 220);
		
		if (as.isReaching10Combo() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Reaching 10 Combo",0,20,270);
		
		if (as.isReaching30Combo() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Reaching 30 Combo",0,20,300);
		
		if (as.isReaching50Combo() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Reaching 50 Combo",0,20,330);
		
		if (as.isSwapping5Planet() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Swapping 5 Planet Within 5 Seconds",0,20,360);

		if (as.isSwapping10Planet() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Swapping 10 Planet Within 5 Seconds",0,20,390);
		
		if (as.isSwapping15Planet() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Swapping 15 Planet Within 5 Seconds",0,20,420);
		
		if (as.isScoreTinggi() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Score is up to 6000",0,20,450);
		
		if (as.isScoreTengah() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Score is up to 4000",0,20,480);
		
		if (as.isScoreRendah() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Score is up to 2000",0,20,510);
		
		if (as.isScore0() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Score is 0",0,20,540);
		
		if (as.isFullPerfect() == true)
			g.setColor(Color.WHITE);
		else
			g.setColor(Color.LIGHT_GRAY);
		DrawText(g, "- Full Perfect Combo",0,20,570);
		
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
