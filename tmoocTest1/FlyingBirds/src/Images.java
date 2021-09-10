import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {
    public static BufferedImage bird=null;
    public static BufferedImage top_column=null;
    public static BufferedImage bottom_column=null;
    public static BufferedImage start;
    public static BufferedImage pause;
    public static BufferedImage game_over;
    public static BufferedImage background;
    static{
        background= loadImage("resources/background.png");
        bird= loadImage("resources/bird.png");
        top_column= loadImage("resources/top_column.png");
        bottom_column= loadImage("resources/bottom_column.png");
        start= loadImage("resources/start.png");
        pause= loadImage("resources/pause.png");
        game_over= loadImage("resources/gameover.png");

    }
    private static BufferedImage loadImage(String fileName){
        BufferedImage img= null;
        try {
            img = ImageIO.read(Bird.class.getResource(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
