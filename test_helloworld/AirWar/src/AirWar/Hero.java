package AirWar;

import java.awt.image.BufferedImage;

public class Hero extends FlyingObject{
    int index=0;
    private int doubleFire=0;
    private int lives=3;
    public void addDoubleFire(){
        doubleFire+=40;
    }
    public void addlife(){
        lives+=1;
    }
    public void subLife(){
        this.lives--;
    }

    public int getDoubleFire() {
        return doubleFire;
    }

    public void setDoubleFire(int doubleFire) {
        this.doubleFire = doubleFire;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public void clearDoubleFire(){
        this.doubleFire=0;
    }

    public Hero(){
        this.width=100;
        this.height=140;
        this.x=150;
        this.y=350;
    }
    @Override
    public BufferedImage getImage() {
        return Images.heros[index++%Images.heros.length];
    }

    @Override
    public void step() {

    }
    public void moveTo(int x,int y ){
        this.x=x-this.width/2;
        this.y=y-this.height/2;
    }
    public Bullet[] shoot(){
        if(doubleFire>0){
            Bullet[] bs=new Bullet[2];
            bs[0]=new Bullet(x+this.width/4,y);
            bs[1]=new Bullet(x+this.width*3/4,y);
            return bs;
        }else{
            Bullet[] bs=new Bullet[1];
            bs[0]=new Bullet(x+this.width/2,y);
            return bs;
        }
    }

}
