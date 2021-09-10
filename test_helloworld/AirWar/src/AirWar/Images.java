package AirWar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;

public class Images {
    public static BufferedImage[] airplanes;
    public static BufferedImage[] bigairplanes;
    public static BufferedImage[] bees;
    public static BufferedImage[] heros;
    public static BufferedImage start;
    public static BufferedImage gameover;
    public static BufferedImage pause;
    public static BufferedImage bullet;
    static{
        bullet=loadImage("resources/bullet.png");
        start=loadImage("resources/start.png");
        gameover=loadImage("resources/gameover.png");
        pause=loadImage("resources/pause.png");
        airplanes=new BufferedImage[5];
        airplanes[0]=loadImage("resources/airplane.png");
        for(int i=1;i< airplanes.length;i++){
            airplanes[i]=loadImage("resources/bom"+i+".png");
        }
        bigairplanes=new BufferedImage[5];
        bigairplanes[0]=loadImage("resources/bigairplane.png");
        for(int i=1;i< bigairplanes.length;i++){
            bigairplanes[i]=loadImage("resources/bom"+i+".png");
        }
        bees=new BufferedImage[5];
        bees[0]=loadImage("resources/bee.png");
        for(int i=1;i< bees.length;i++){
            bees[i]=loadImage("resources/bom"+i+".png");
        }
        heros=new BufferedImage[2];
        for(int i=0;i< heros.length;i++){
            heros[i]=loadImage("resources/hero"+i+".png");
        }
    }
    private static BufferedImage loadImage(String fileName){
        BufferedImage img= null;
        try {
            img = ImageIO.read(FlyingObject.class.getResource(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
