package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Image;
import java.math.*;

public class Ball extends Sprite{
	public static int SIZE = 128;
	
    private int outofarea=0;
    //side=1 for kanan, side=0 for kiri
    private int side;
    int ballCount;
    
    public int targetX;
    public int targetY;
    private boolean isOut;
    
    public Ball(int x, int y, int side) 
    {
        super(x, y);
        this.side = side;
        initBall();
    }
    
    private void initBall() 
    {
    	if (side==0)
    		loadImage(AssetManager.PLANET_LEFT);
    	else if (side==1)
    		loadImage(AssetManager.PLANET_RIGHT);
    	//getImageDimensions();
    }
    
    public int getCount()
    {
    	return ballCount;
    }
    
    public void setCount(int ballCount)
    {
    	this.ballCount = ballCount;
    }
    
    public void moveLeft() {

        move(-64 - 32, targetY);
    }
    
    public void move(int x, int y)
    {
    	//this.x = x;
    	//this.y = y;
    	targetX = x;
    	targetY = y;
    }
    
    public void moveRight() {

    	move(480 + 64 - 32, targetY);
    }
    
    public void Out() {
    	if (side == 0) {
    		moveLeft();
    	} else if (side == 1) {
    		moveRight();
    	}
    	isOut = true;
    }
    
    public boolean getOut() {
    	return isOut;
    }
    
    public int getSide()
    {
    	return side;
    }
    
    public void Animating()
    {
    	
    	if (x >= 0) {
    		x = (int)Math.ceil(x + (targetX - x) * 0.2);
    	} else {
    		x = (int)Math.floor(x + (targetX - x) * 0.2);
    	}
    	if (y >= 0) {
    		y = (int)Math.ceil(y + (targetY - y) * 0.2);
    	} else {
    		y = (int)Math.floor(y + (targetY - y) * 0.2);
    	}
    	
    	//x = targetX;
    	//y = targetY;
    }
}
