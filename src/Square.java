import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Square {
    private boolean taken;
    private boolean tru;
    public Square (boolean taken, boolean tru) {
        this.taken = taken;
        this.tru = tru;
    }

    public boolean isTaken() {
        return taken;
    }

    public boolean isTru() {
        return tru;
    }

}
