package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class SceneGameplay extends Scene {
	private GameMaster gameMaster;
	
	public SceneGameplay() {
		super(480, 640);
		
		gameMaster = new GameMaster();
	}
	
	@Override
	public void drawObjects(Graphics g) {
		List<Ball> temp = new ArrayList(gameMaster.GetPangQueue());
		for (Ball b : temp) {
			b.getImage();
		}
	}
	
	@Override
	public void clearObjects(Graphics g) {
		
	}
}
