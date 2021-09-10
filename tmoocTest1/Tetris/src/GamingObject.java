import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GamingObject {
    protected int x;
    protected int y;
    protected double centerX;
    protected double centerY;

    public double getCenterX() {
        return centerX;
    }

    public void rotate(){};
    public double getCenterY() {
        return centerY;
    }

    protected  static final int width=1,height=1,step=1;
    public abstract BufferedImage getImage();
    public abstract void step();
    public void paint(Graphics g){
        g.drawImage(getImage(),x*PlayingPanel.BLOCKSIZE,y*PlayingPanel.BLOCKSIZE,PlayingPanel.BLOCKSIZE,PlayingPanel.BLOCKSIZE,null);
    }
    public void stepLeft(){
        x-=step;
    }
    public void stepRight(){
        x+=step;
    }
    public void stepDown(){
        y+=step;
    }
}
