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
	
	private final int scorePosX = 320;
	private final int scorePosY = 40;
	
	private final int comboPosX = 320;
	private final int comboPosY = 420;
	
	private final int FPS = 60;
	private int gameplayCounter = FPS * 5;
	private int errorCounter = 0;
	
	private boolean isGameOver = false;
	private final int gameOverPosX = 180;
	private final int gameOverPosY = 320;
	private int gameOverCounter = FPS * 3;
	
	private final int ERROR_MAX = 3 * FPS;
	private boolean isError = false;
	
	private final int errorPosX = 240;
	private final int errorPosY = 320;
	
	private boolean highscoreSaved = false;
	
	private Image backgroundSpace;
	
	private final Font small = new Font("AgencyFB", Font.BOLD, 24);
	private final Font medium = new Font("AgencyFB", Font.BOLD, 42);
	private final Font big = new Font("AgencyFB", Font.BOLD, 64);
	
	private boolean loadedScene = false;
	
	public SceneGameplay() {
		super(480, 640);

		isGameOver = false;
		isError = false;
		highscoreSaved = false;
		
		backgroundSpace = AssetManager.BACKGROUND_SPACE; 
		
		addKeyListener(new TAdapter());
		
		gameMaster = new GameMaster();
		gameMaster.LoadHighscore();
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
		if (!isGameOver) {
			DrawUI(g);
		} else {
			DrawGameOver(g);
		}
	}
	
	private void DrawGameOver(Graphics g) {
		g.setFont(medium);
		g.setColor(Color.white);
		g.drawString(("Game Over"), gameOverPosX, gameOverPosY);
		g.drawString(String.format("%d", gameMaster.GetScore()), gameOverPosX + 10, gameOverPosY + 64);
		
		if (!highscoreSaved) {
			gameMaster.UpdateHighscore();
			highscoreSaved = true;
		}
	
		if (gameOverCounter > 0) {
			gameOverCounter -= 1;
		} else {
			//Load Highscore
			if (!loadedScene) {
				SceneManager.LoadHighscoreScene();
				loadedScene = true;
			}
		}
	}
	
	private void DrawUI(Graphics g) {
        g.setFont(medium);
        
        g.setColor(Color.WHITE);
		g.drawString("Combo", comboPosX, comboPosY);
        
		if (gameMaster.GetCombo() > 0) {
			String msg = String.format("%d",gameMaster.GetCombo());
			
	        g.setColor(Color.white);
			g.drawString(msg, comboPosX + 12, comboPosY + 48);
		}
		
		if (isError) {
			g.setFont(big);
			if (errorCounter > 0) {
				String msg = String.format("%d",(int)Math.ceil(errorCounter) / FPS + 1); 
				g.drawString(msg, errorPosX, errorPosY);
				errorCounter -= 1;
			} else {
				isError = false;
			}
		}
		
		//Score
		g.setFont(small);
		g.setColor(Color.white);
		g.drawString(String.format("Score : %d",gameMaster.GetScore()), scorePosX, scorePosY);
		g.drawString(String.format("HScore : %d",gameMaster.GetHighscore()), scorePosX, scorePosY + 32);
		
		//Timer
		if (gameplayCounter > 0) {
			g.setFont(small);
			g.setColor(Color.white);
			g.drawString(String.format("Time : %d",gameplayCounter / FPS + 1), scorePosX, scorePosY + 64);
			
			gameplayCounter -= 1;
		} else {
			isGameOver = true;
		}
	}
	
	@Override
	public void clearObjects(Graphics g) {
		
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
	
	private void SetError() {
		isError = true;
		errorCounter = ERROR_MAX;
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
			if (!isError && !isGameOver) {
		    	int key = e.getKeyCode();
		        if (key == KeyEvent.VK_LEFT && !left) {
		        	if (gameMaster.CheckPang(0)) {
		        		MoveLeft();
		        	} else {
		        		SetError();
		        	}
		        	left = true;
		        } else if (key == KeyEvent.VK_RIGHT && !right) {
		        	if (gameMaster.CheckPang(1)) {
		        		MoveRight();
		        	} else {
		        		SetError();
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
	}
}
