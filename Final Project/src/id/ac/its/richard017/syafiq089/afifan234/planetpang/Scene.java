package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Scene extends JPanel implements ActionListener, IScene {
	
    private Timer timer;
    private boolean ingame;
    private final int DELAY = 10;
    private final int B_WIDTH;
    private final int B_HEIGHT;

    public Scene() {
    	B_WIDTH = 640;
    	B_HEIGHT = 480;
        initBoard();
    }
    
    public Scene(int dimensionX, int dimensionY) {
    	B_WIDTH = dimensionX;
    	B_HEIGHT = dimensionY;
    	initBoard();
    }

    private void initBoard() {        
        
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {
            drawObjects(g);

        } else {

            clearObjects(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        repaint();
    }

    private void inGame() {
        if (!ingame) {
            timer.stop();
        }
    }
    
	@Override
	public void drawObjects(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearObjects(Graphics g) {
		// TODO Auto-generated method stub		
	}
}