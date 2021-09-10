import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Images {
    public static BufferedImage cell=null;
    static {
        cell= loadImage("resources/cell.png");
    }
    private static BufferedImage loadImage(String fileName){
        BufferedImage img= null;
        try {
            img = ImageIO.read(Cell.class.getResource(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
