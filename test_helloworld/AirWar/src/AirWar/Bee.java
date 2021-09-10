package AirWar;

import java.awt.image.BufferedImage;

public class Bee extends FlyingObject implements Award{
    private int awardType;
    private int xStep;
    private int yStep;
    public Bee(){
        width=60;
        height=51;
        x=(int)(Math.random()*(World.WIDTH-this.width));
        y=-this.height;
        awardType=(int)(Math.random()*2);
        xStep=1;
        yStep=2;
    }
    @Override
    public int getType() {
        return this.awardType;
    }
    int deadIndex=1;
    @Override
    public BufferedImage getImage() {
        BufferedImage img=null;
        if(this.isLife()){
            img=Images.bees[0];
        }else if(isDead()){
            img=Images.bees[deadIndex++];
            if(deadIndex==Images.bees.length){
                this.state=REMOVE;
            }
        }
        return img;
    }

    @Override
    public void step() {
        x+=xStep;
        y+=yStep;
        if(x==World.WIDTH-this.width||x==0){
            xStep*=-1;
        }
    }
}
