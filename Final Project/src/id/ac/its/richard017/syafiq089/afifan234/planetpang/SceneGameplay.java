package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class SceneGameplay extends Scene {
	private GameMaster gameMaster;
	
	private int rootX = 240 - 32;
	private int rootY = 480;
	
	public SceneGameplay() {
		super(480, 640);
		
		Ball.LoadTexture();
		
		addKeyListener(new TAdapter());
		gameMaster = new GameMaster();
	}
	
	@Override
	public void drawObjects(Graphics g) {
		List<Ball> temp = new ArrayList<Ball>(gameMaster.GetOldPangQueue());
		for (Ball b : temp) {
			if (b.isVisible()) {
				
				b.move(rootX,rootY + Ball.SIZE * (GameMaster.COUNT - b.getCount()));
				b.Animating();
				g.drawImage(b.getImage(), b.getX(), b.getY(), this);
			}
		}
	}
	
	@Override
	public void clearObjects(Graphics g) {
		
	}
	
	private class TAdapter extends KeyAdapter {
		private boolean left = false;
		private boolean right = false;
		@Override
	    public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
	        if (key == KeyEvent.VK_LEFT) {
	        	left = false;
	        } else if (key == KeyEvent.VK_RIGHT) {
	        	right = false;
	        }
	    }
		
		@Override
	    public void keyPressed(KeyEvent e) {
	    	int key = e.getKeyCode();
	        if (key == KeyEvent.VK_LEFT && !left) {
	        	gameMaster.CheckPang(0);
	        	left = true;
	        } else if (key == KeyEvent.VK_RIGHT && !right) {
	        	gameMaster.CheckPang(1);
	        	right = true;
	        }
	        
	        if (key == KeyEvent.VK_UP) {
	        	GameMaster.COUNT += 1;
	        }
	        
	        if (key == KeyEvent.VK_DOWN) {
	        	GameMaster.COUNT -= 1;
	        }
	    }
	}
}
