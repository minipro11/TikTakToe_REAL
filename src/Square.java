
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Square {
    private BufferedImage img;
    private int x;
    private int y;
    public Square (int xCord, int yCord, String Img) {
        x = xCord;
        y = yCord;
        try {
            img = ImageIO.read(new File(Img));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public BufferedImage getImg() {
        return img;
    }
}
