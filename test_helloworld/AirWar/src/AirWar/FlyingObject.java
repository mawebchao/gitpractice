package AirWar;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class FlyingObject {
    protected int width;
    protected int height;
    protected int x;
    protected int y;

    public static final int LIFE = 0;
    public static final int DEAD = 1;
    public static final int REMOVE = 2;
    protected int state = LIFE;

    public abstract BufferedImage getImage();

    public void paint(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }

    public boolean isLife() {
        return state == LIFE;
    }

    public boolean isDead() {
        return state == DEAD;
    }

    public boolean isRemove() {
        return state == REMOVE;
    }

    public void goDead() {
        state = DEAD;
    }

    public boolean hit(FlyingObject f) {
        int x1 = this.x - f.width;
        int x2 = this.x + this.width;
        int y1 = this.y - f.height;
        int y2 = this.y + this.height;
        int x = f.x;
        int y = f.y;
        return x >= x1 && x <= x2 && y >= y1 && y <=y2;
    }

    public abstract void step();

}
