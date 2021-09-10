import java.awt.image.BufferedImage;

public class Cell extends GamingObject{
    public static final int ACTIVE=0;
    public static final int DISAPPEARING=2;
    public static final int DISAPPEARED=1;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    public void stepLeft(){
        x-=step;
        centerX-=step;
    }
    public void stepRight(){
        x+=step;
        centerX+=step;
    }
    public void stepDown(){
        y+=step;
        centerY+=step;
    }
    private int state=ACTIVE;
    public Cell(int x, int y){
        this.x=x;
        this.y=y;
        this.centerX=x+0.5;
        this.centerY=y+0.5;
    }
    @Override
    public BufferedImage getImage() {
        return Images.cell;
    }

    @Override
    public void step() {
        this.y+=step;
        this.centerY+=step;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                ", centerX=" + centerX +
                ", centerY=" + centerY +
                '}';
    }
}
