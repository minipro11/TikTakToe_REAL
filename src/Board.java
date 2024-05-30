import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board {
    private BufferedImage board;
    private Square one;
    private Square two;
    private Square three;
    private Square four;
    private Square five;
    private Square six;
    private Square seven;
    private Square eight;
    private Square nine;
    public Board (Square one, Square two, Square three, Square four, Square five, Square six, Square seven, Square eight, Square nine) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.five = five;
        this.six = six;
        this.seven = seven;
        this.eight = eight;
        this.nine = nine;

    }


}
