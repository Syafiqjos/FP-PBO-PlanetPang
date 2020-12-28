package id.ac.its.richard017.syafiq089.afifan234.planetpang;

import java.awt.Image;
import java.math.*;

public class Ball extends Sprite{
	public static int SIZE = 128;
	public static Image IMAGE_LEFT;
	public static Image IMAGE_RIGHT;
	
    private int outofarea=0;
    //side=1 for kanan, side=0 for kiri
    private int side;
    int ballCount;
    
    public int targetX;
    public int targetY;
    
    public Ball(int x, int y, int side) 
    {
        super(x, y);
        this.side = side;
        initBall();
    }

    public static void LoadTexture() {
    	IMAGE_LEFT = loadImage("sprite/Planet1.jpg");
    	IMAGE_RIGHT = loadImage("sprite/Planet2.png");
    }
    
    private void initBall() 
    {
    	if (side==0)
    		loadImage(IMAGE_LEFT);
    	else if (side==1)
    		loadImage(IMAGE_RIGHT);
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

        if (x < 0) {
            outofarea=1;
        }
        
        if (outofarea != 1)
        	x -= 1;
    }
    
    public void move(int x, int y)
    {
    	//this.x = x;
    	//this.y = y;
    	targetX = x;
    	targetY = y;
    }
    
    public void moveRight() {

        if (x > 480) {
            outofarea=1;
        }
        
        if (outofarea != 1)
        	x -= 1;
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
    	
    	if (ballCount == 0) {
    		System.out.println(y);
    	}
    }
}
