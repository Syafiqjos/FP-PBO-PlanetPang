package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseMotionListener, MouseListener {
	
	private final int POS_X_MAX;
	private final int POS_Y_MAX;
	
	public MouseHandler(int xMax, int yMax) {
		POS_X_MAX = xMax;
		POS_Y_MAX = yMax;
	}
	
    @Override
    public void mouseDragged(MouseEvent e) {
    	mouseMovement(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    	mouseMovement(e);
    }
    
    private void mouseMovement(MouseEvent e) {
    	int tempX = e.getX();
    	int tempY = e.getY();
    	
    	if (tempX <= 0) {
    		tempX = 0;
    	} else if (tempX >= POS_X_MAX) {
    		tempX = POS_X_MAX;
    	}
    	
    	if (tempY <= 0) {
    		tempY = 0;
    	} else if (tempY >= POS_Y_MAX) {
    		tempY = POS_Y_MAX;
    	}
    	
    	//Pake tempX dan tempY
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}