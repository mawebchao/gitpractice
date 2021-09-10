import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {
    public int width;
    public int height;
    public int x;
    public int y;

    public abstract BufferedImage getImage();

    public void paint(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }

    public abstract void step();

    public boolean hit(Bird other) {
        boolean return_bool = false;
        //Utils.isInside(other.getXys(),x,y)||Utils.isInside(other.getXys(),x+this.width,y)||
        boolean this_in_bird= Utils.isInside(other.getXys(),x,y+this.height)||Utils.isInside(other.getXys(),x+this.width,y+this.height);
        boolean bird_in_this=Utils.isInside(this.x,this.x+this.width,this.y,this.y+this.height,other.getXys().get("X1"),other.getXys().get("Y1"))||Utils.isInside(this.x,this.x+this.width,this.y,this.y+this.height,other.getXys().get("X2"),other.getXys().get("Y2"))||Utils.isInside(this.x,this.x+this.width,this.y,this.y+this.height,other.getXys().get("X3"),other.getXys().get("Y3"))||Utils.isInside(this.x,this.x+this.width,this.y,this.y+this.height,other.getXys().get("X4"),other.getXys().get("Y4"));
        return this_in_bird||bird_in_this;
    }
}
