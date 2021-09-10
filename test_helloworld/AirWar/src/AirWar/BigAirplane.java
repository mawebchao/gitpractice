package AirWar;

import java.awt.image.BufferedImage;

public class BigAirplane extends FlyingObject implements Enemy{
    private int step;
    public BigAirplane(){
        width=66;
        height=89;
        x=(int)(Math.random()*(World.WIDTH-this.width));
        y=-this.height;
        step=5;
    }
    @Override
    public int getScore() {
        return 2;
    }
    int deadIndex=1;
    @Override
    public BufferedImage getImage() {
        BufferedImage img=null;
        if(this.isLife()){
            img=Images.bigairplanes[0];
        }else if(isDead()){
            img=Images.bigairplanes[deadIndex++];
            if(deadIndex==Images.bigairplanes.length){
                this.state=REMOVE;
            }
        }
        return img;
    }

    @Override
    public void step() {
        this.y+=step;
    }
}
