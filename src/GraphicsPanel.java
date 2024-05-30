
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;




public class GraphicsPanel extends JPanel implements MouseListener, KeyListener {
    private BufferedImage board;
    private BufferedImage circle;
    private BufferedImage X;
    private boolean turn = true;
    private Square one;
    private Square two;
    private Square three;
    private Square four;
    private Square five;
    private Square six;
    private Square seven;
    private Square eight;
    private Square nine;


    public GraphicsPanel() {

        try {
            board = ImageIO.read(new File("src/board.png"));
            circle = ImageIO.read(new File("src/circle.png"));
            X = ImageIO.read(new File("src/X.png"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true); // this line of code + one below makes this panel active for keylistener events
        requestFocusInWindow(); // see comment above
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ImageIcon ci = new ImageIcon("src/circle.png");
        Image circ = ci.getImage();
        Image modifiedCircle = circ.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ci = new ImageIcon(modifiedCircle);
        g.drawImage(X, 50, 0, null);
        g.drawImage(circle, 100, 0, null);

        g.drawLine(0, 50, 100, 50);





    }




    @Override
    public void mouseClicked(MouseEvent e) {

    }


    @Override
    public void mousePressed(MouseEvent e) {


    }


    @Override
    public void mouseReleased(MouseEvent e) {
        Graphics g;
        if (e.getButton() == MouseEvent.BUTTON1) {
            Point mouseClickLocation = e.getPoint();
            if (mouseClickLocation.x >= 0 && mouseClickLocation.y >= 0 && mouseClickLocation.x <= 50 && mouseClickLocation.y <= 50) {
                Circle h = new Circle(300, 0);
            }
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {


    }


    @Override
    public void mouseExited(MouseEvent e) {


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
