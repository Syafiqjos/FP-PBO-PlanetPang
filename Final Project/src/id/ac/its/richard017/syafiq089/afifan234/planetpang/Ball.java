package id.ac.its.richard017.syafiq089.afifan234.planetpang;

public class Ball extends Sprite{

    private int outofarea=0;
    //side=1 for kanan, side=0 for kiri
    private int side;
    int ballCount;
    
    public Ball(int x, int y, int side) 
    {
        super(x, y);
        this.side = side;
        initBall();
    }

    private void initBall() 
    {
    	if (side==0)
    		loadImage("sprite/ball0.png");
    	else if (side==1)
    		loadImage("sprite/ball1.png");
    	getImageDimensions();
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
    	this.x = x;
    	this.y = y;
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
    	
    }
}
