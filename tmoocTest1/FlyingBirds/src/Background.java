import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject{
    private int step;
    private int x1;
    public Background(){
        this.width=658;
        this.height=371;
        this.x=0;
        this.x1=this.width;
        this.y=0;
        step=5;
    }
    @Override
    public BufferedImage getImage() {
        return Images.background;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(getImage(),x,y,null);
        g.drawImage(getImage(),x1,y,null);
    }

    @Override
    public void step() {
        this.x-=step;
        this.x1-=step;
        if(x1<=-this.width){
            x1=this.width-8;
        }
        if(x<=-this.width){
            x=this.width-8;
        }
    }
}
