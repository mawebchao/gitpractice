package AirWar;

import java.awt.image.BufferedImage;

public class Airplane extends FlyingObject implements Enemy{
    private int step;


    public Airplane() {
        width = 48;
        height = 50;
        x = (int) (Math.random() * (World.WIDTH - this.width));
        y = -this.height;
        step=5;
    }

    int deadIndex = 1;

    @Override
    public BufferedImage getImage() {
        if (isLife()) {
            return Images.airplanes[0];
        } else if (isDead()) {
            BufferedImage img = Images.airplanes[deadIndex++];
            if (deadIndex == Images.airplanes.length)
                state = REMOVE;
            return img;
        }
        return null;
    }

    @Override
    public void step() {
        this.y+=step;
    }

    @Override
    public int getScore() {
        return 1;
    }
}
