package id.ac.its.richard017.syafiq089.afifan234.planetpang;

public class Ball extends Sprite{

    private int outofarea=0;
    //side=1 for kanan, side=0 for kiri
    private int side;
    public Ball(int x, int y, int side) 
    {
        super(x, y);
        this.side = side;
        initBall();
    }

    private void initBall() 
    {
        loadImage("src/resources/ball.png");
        getImageDimensions();
    }

    public void moveleft() {

        if (x < 0) {
            outofarea=1;
        }
        
        if (outofarea != 1)
        	x -= 1;
    }
    
    public int getSide()
    {
    	return side;
    }
}
