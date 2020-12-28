package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class SceneGameplay extends Scene {
	private GameMaster gameMaster;
	
	public SceneGameplay() {
		super(480, 640);
		
		addKeyListener(new TAdapter());
		gameMaster = new GameMaster();
	}
	
	@Override
	public void drawObjects(Graphics g) {
		List<Ball> temp = new ArrayList<Ball>(gameMaster.GetPangQueue());
		for (Ball b : temp) {
			if (b.isVisible()) {
				g.drawImage(b.getImage(), b.getX(), b.getY(), this);
			}
		}
	}
	
	@Override
	public void clearObjects(Graphics g) {
		
	}
	
	private class TAdapter extends KeyAdapter {

	    @Override
	    public void keyReleased(KeyEvent e) {
	    }

	    @Override
	    public void keyPressed(KeyEvent e) {
	    	int key = e.getKeyCode();
	        if (key == KeyEvent.VK_LEFT) {
	        	gameMaster.CheckPang(0);
	        } else if (key == KeyEvent.VK_RIGHT) {
	        	gameMaster.CheckPang(1);
	        }
	    }
	}
}
