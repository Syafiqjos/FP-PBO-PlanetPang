package id.ac.its.richard0017.pangpang;

public class Ball extends Sprite{

    private int outofarea=0;
    public Ball(int x, int y) {
        super(x, y);

        initBall();
    }

    private void initBall() {

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
}
