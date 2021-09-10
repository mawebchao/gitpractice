package AirWar;

import java.awt.image.BufferedImage;

public class Bullet extends FlyingObject{
    private int step;
    public Bullet(int x,int y){
        step=5;
        width=8;
        height=20;
        this.x=x;
        this.y=y;
    }
    @Override
    public BufferedImage getImage() {
        return Images.bullet;
    }

    @Override
    public void step() {
        y-=step;
    }
}
