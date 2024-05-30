import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Circle {
    private int x;
    private int y;
    private BufferedImage image;

    public Circle(int xCord, int yCord) {
        x = xCord;
        y = yCord;
        try {
            image = ImageIO.read(new File("src/circle.png"));
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

    public BufferedImage image() {
        return image;
    }
}
