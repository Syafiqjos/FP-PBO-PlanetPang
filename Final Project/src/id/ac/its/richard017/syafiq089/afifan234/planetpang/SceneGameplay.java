package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class SceneGameplay extends Scene {
	private GameMaster gameMaster;
	
	private int rootX = 240 - 32;
	private int rootY = 480;
	
	private int targetX = rootX;
	private int targetY = rootY;
	
	private boolean isFrenzy = true;
	private final int frenzyDelta = 64;
	private final int frenzyRight = rootX + 128;
	private final int frenzyLeft = rootX - 128;
	
	private Image backgroundSpace;
	
	public SceneGameplay() {
		super(480, 640);
		
		backgroundSpace = AssetManager.BACKGROUND_SPACE; 
		
		addKeyListener(new TAdapter());
		gameMaster = new GameMaster();
	}
	
	@Override
	public void drawObjects(Graphics g) {
		
		g.drawImage(backgroundSpace, 0, 0, this);
		
		List<Ball> temp = new ArrayList<Ball>(gameMaster.GetOldPangQueue());
		for (Ball b : temp) {
			if (b.isVisible()) {
				
				if (!b.getOut()) {
					b.move(rootX,rootY + Ball.SIZE * (GameMaster.COUNT - b.getCount()));
				}
				b.Animating();
				g.drawImage(b.getImage(), b.getX(), b.getY(), this);
			}
		}
		
		Animating();
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
	        	if (gameMaster.CheckPang(0)) {
	        		MoveLeft();
	        	}
	        	left = true;
	        } else if (key == KeyEvent.VK_RIGHT && !right) {
	        	if (gameMaster.CheckPang(1)) {
	        		MoveRight();
	        	}
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
	
	public void Animating()
    {
    	if (isFrenzy) {
	    	if (rootX >= 0) {
	    		rootX = (int)Math.ceil(rootX + (targetX - rootX) * 0.4);
	    	} else {
	    		rootX = (int)Math.floor(rootX + (targetX - rootX) * 0.4);
	    	}
	    	
	    	NormalizeTarget();
	    	
	    	if (rootY >= 0) {
	    		rootY = (int)Math.ceil(rootY + (targetY - rootY) * 0.4);
	    	} else {
	    		rootY = (int)Math.floor(rootY + (targetY - rootY) * 0.4);
	    	}
    	}
    	
    	//x = targetX;
    	//y = targetY;
    }
	
	private void MoveLeft() {
		targetX -= frenzyDelta;
		NormalizeTarget();
	}

	private void MoveRight() {
		targetX += frenzyDelta;
		NormalizeTarget();
	}
	
	private void NormalizeTarget() {
		if (rootX >= frenzyRight) {
    		rootX = frenzyRight;
    	} else if (rootX <= frenzyLeft) {
    		rootX = frenzyLeft;
    	}
		
		if (targetX >= frenzyRight) {
    		targetX = frenzyRight;
    	} else if (targetX <= frenzyLeft) {
    		targetX = frenzyLeft;
    	}
	}
}
