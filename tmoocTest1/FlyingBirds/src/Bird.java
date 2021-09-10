import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Bird extends GameObject {
    private double yVelocity = 0;
    private BufferedImage img = null;
    private double alpha;

    public HashMap<String, Double> getXys() {
        return xys;
    }

    private HashMap<String, Double> xys = null;

    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }

    public double getAlpha() {
        return alpha;
    }


    public Bird() {
        xys = new HashMap<String, Double>();
        this.alpha = 0;
        this.width = 40;
        this.height = 35;
        this.x = 50;
        this.y = PlayingPanel.HEIGHT / 2 - this.height;
        this.img = Images.bird;
    }

    public void setVelocity(double force_a) {
        if (force_a < 0)
            this.yVelocity = force_a;
        else
            this.yVelocity += 0.2;
    }

    public void step(double force_a) {
        this.alpha += 0.005;
        updateXYS();
        setVelocity(force_a);
        this.y += yVelocity;
    }

    @Override
    public BufferedImage getImage() {
        return Images.bird;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(getImage(), x, y,40,35, null);
    }

    @Override
    public void step() {

    }
    private void updateXYS(){
        HashMap<String,Double> new_xys=new HashMap<String,Double>();
        HashMap<String, Double> map = new HashMap<String, Double>() {
            {
                put("X", 0.0);
                put("Y", 0.0);
            }
        };
        map.put("X",(double)this.x);
        map.put("Y",(double)this.y);
        HashMap<String, Double> xy1 = Utils.getRotatedXY(this.alpha, this.x + this.width / 2, this.y + this.height / 2, map);
        new_xys.put("X1",xy1.get("X"));
        new_xys.put("Y1",xy1.get("Y"));

        map.put("X",(double)this.x+this.width);
        map.put("Y",(double)this.y);
        xy1 = Utils.getRotatedXY(this.alpha, this.x + this.width / 2, this.y + this.height / 2, map);
        new_xys.put("X2",xy1.get("X"));
        new_xys.put("Y2",xy1.get("Y"));

        map.put("X",(double)this.x);
        map.put("Y",(double)this.y+this.height);
        xy1 = Utils.getRotatedXY(this.alpha, this.x + this.width / 2, this.y + this.height / 2, map);
        new_xys.put("X3",xy1.get("X"));
        new_xys.put("Y3",xy1.get("Y"));

        map.put("X",(double)this.x+this.width);
        map.put("Y",(double)this.y+this.height);
        xy1 = Utils.getRotatedXY(this.alpha, this.x + this.width / 2, this.y + this.height / 2, map);
        new_xys.put("X4",xy1.get("X"));
        new_xys.put("Y4",xy1.get("Y"));

        this.xys=new_xys;
    }
}
