
import com.sun.source.doctree.SerialFieldTree;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GraphicsPanel extends JPanel implements MouseListener, KeyListener {
    private BufferedImage board;
    private BufferedImage button;
    private boolean turn = true;
    private boolean circleWin = false;
    private boolean XWin = false;
    private boolean again = false;
    private ArrayList<Square> list = new ArrayList<>();
    private final ArrayList<Square> reset = new ArrayList<>();
    private final Move box1 = new Move();
    private final Move box2 = new Move();
    private final Move box3 = new Move();
    private final Move box4 = new Move();
    private final Move box5 = new Move();
    private final Move box6 = new Move();
    private final Move box7 = new Move();
    private final Move box8 = new Move();
    private final Move box9 = new Move();
    private final Move[] moves = {box1, box2, box3, box4, box5, box6, box7, box8, box9};


    public GraphicsPanel() {
        try {
            board = ImageIO.read(new File("src/board.png"));
            button = ImageIO.read(new File("src/button.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);
        g2d.setStroke(new BasicStroke(10));
        g.drawImage(board, 0, 0, null);
        for (Square square : list) {
            g.drawImage(square.getImg(), square.getX(), square.getY(), null);
        }
        if (circleWin) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
            g.drawString("BLUE WINS", 160, 220);
            g.drawImage(button, 350, 100, null);
            again = true;
        }
        if (XWin) {
            g.setColor(Color.RED);
            g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
            g.drawString("RED WINS", 190, 220);
            g.drawImage(button, 350, 100, null);
            again = true;
        }
        if (!(box1.canMove() || box2.canMove() || box3.canMove() || box4.canMove() || box5.canMove() || box6.canMove() || box7.canMove() || box8.canMove() || box9.canMove())) {
            if (!(circleWin || XWin)) {
                g.setColor(Color.BLACK);
                g.setFont(new Font("Times New Roman", Font.PLAIN, 100));
                g.drawString("IT'S A TIE", 210, 220);
                g.drawImage(button, 350, 100, null);
                again = true;
            }
        }

        if (moves[0].getCircle() && moves[1].getCircle() && moves[2].getCircle() || (moves[0].getX() && moves[1].getX() && moves[2].getX())) {
            g.drawLine(140, 330, 700, 330);
        }
        if (moves[3].getCircle() && moves[4].getCircle() && moves[5].getCircle() || (moves[3].getX() && moves[4].getX() && moves[5].getX())) {
            g.drawLine(140, 520, 700, 520);
        }
        if (moves[6].getCircle() && moves[7].getCircle() && moves[8].getCircle() || (moves[6].getX() && moves[7].getX() && moves[8].getX())) {
            g.drawLine(140, 705, 700, 705);
        }
        if (moves[0].getCircle() && moves[3].getCircle() && moves[6].getCircle() || (moves[0].getX() && moves[3].getX() && moves[6].getX())) {
            g.drawLine(235, 245, 235, 800);
        }
        if (moves[1].getCircle() && moves[4].getCircle() && moves[7].getCircle() || (moves[1].getX() && moves[4].getX() && moves[7].getX())) {
            g.drawLine(425, 245, 425, 800);
        }
        if (moves[2].getCircle() && moves[5].getCircle() && moves[8].getCircle() || (moves[2].getX() && moves[5].getX() && moves[8].getX())) {
            g.drawLine(615, 245, 615, 800);
        }
        if (moves[0].getCircle() && moves[4].getCircle() && moves[8].getCircle() || (moves[0].getX() && moves[4].getX() && moves[8].getX())) {
            g.drawLine(140, 235, 700, 790);
        }
        if (moves[2].getCircle() && moves[4].getCircle() && moves[6].getCircle() || (moves[2].getX() && moves[4].getX() && moves[6].getX())) {
            g.drawLine(140, 800, 700, 245);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        Square x = null;
        if (e.getButton() == MouseEvent.BUTTON1) {
            Point mouseClickLocation = e.getPoint();
            int col1 = 153;
            int col2 = 336;
            int col3 = 520;
            int row1 = 250;
            int row2 = 431;
            int row3 = 614;
            if (box1.canMove()) {
                if (mouseClickLocation.x >= col1 && mouseClickLocation.y >= row1 && mouseClickLocation.x <= col1 + 175 && mouseClickLocation.y <= row1 + 173) {
                    if (turn) {
                        x = new Square(150, 250, "src/circle.png");
                        box1.setCircle(true);
                    } else {
                        x = new Square(150, 250, "src/X.png");
                        box1.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box1.moved();
                }
            }

            if (box2.canMove()) {
                if (mouseClickLocation.x >= col2 && mouseClickLocation.y >= row1 && mouseClickLocation.x <= col2 + 175 && mouseClickLocation.y <= row1 + 173) {
                    if (turn) {
                        x = new Square(340, 250, "src/circle.png");
                        box2.setCircle(true);
                    } else {
                        x = new Square(340, 250, "src/X.png");
                        box2.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box2.moved();
                }
            }

            if (box3.canMove()) {
                if (mouseClickLocation.x >= col3 && mouseClickLocation.y >= row1 && mouseClickLocation.x <= col3 + 175 && mouseClickLocation.y <= row1 + 173) {
                    if (turn) {
                        x = new Square(530, 250, "src/circle.png");
                        box3.setCircle(true);
                    } else {
                        x = new Square(530, 250, "src/X.png");
                        box3.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box3.moved();
                }
            }

            if (box4.canMove()) {
                if (mouseClickLocation.x >= col1 && mouseClickLocation.y >= row2 && mouseClickLocation.x <= col1 + 175 && mouseClickLocation.y <= row2 + 173) {
                    if (turn) {
                        x = new Square(150, 436, "src/circle.png");
                        box4.setCircle(true);
                    } else {
                        x = new Square(150, 436, "src/X.png");
                        box4.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box4.moved();
                }
            }
            if (box5.canMove()) {
                if (mouseClickLocation.x >= col2 && mouseClickLocation.y >= row2 && mouseClickLocation.x <= col2 + 175 && mouseClickLocation.y <= row2 + 173) {
                    if (turn) {
                        x = new Square(340, 436, "src/circle.png");
                        box5.setCircle(true);
                    } else {
                        x = new Square(340, 436, "src/X.png");
                        box5.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box5.moved();
                }
            }
            if (box6.canMove()) {
                if (mouseClickLocation.x >= col3 && mouseClickLocation.y >= row2 && mouseClickLocation.x <= col3 + 175 && mouseClickLocation.y <= row2 + 173) {
                    if (turn) {
                        x = new Square(530, 436, "src/circle.png");
                        box6.setCircle(true);
                    } else {
                        x = new Square(530, 436, "src/X.png");
                        box6.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box6.moved();
                }
            }

            if (box7.canMove()) {
                if (mouseClickLocation.x >= col1 && mouseClickLocation.y >= row3 && mouseClickLocation.x <= col1 + 175 && mouseClickLocation.y <= row3 + 173) {
                    if (turn) {
                        x = new Square(150, 622, "src/circle.png");
                        box7.setCircle(true);
                    } else {
                        x = new Square(150, 622, "src/X.png");
                        box7.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box7.moved();
                }
            }
            if (box8.canMove()) {
                if (mouseClickLocation.x >= col2 && mouseClickLocation.y >= row3 && mouseClickLocation.x <= col2 + 175 && mouseClickLocation.y <= row3 + 173) {
                    if (turn) {
                        x = new Square(340, 622, "src/circle.png");
                        box8.setCircle(true);
                    } else {
                        x = new Square(340, 622, "src/X.png");
                        box8.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box8.moved();
                }
            }
            if (box9.canMove()) {
                if (mouseClickLocation.x >= col3 && mouseClickLocation.y >= row3 && mouseClickLocation.x <= col3 + 175 && mouseClickLocation.y <= row3 + 173) {
                    if (turn) {
                        x = new Square(530, 622, "src/circle.png");
                        box9.setCircle(true);
                    } else {
                        x = new Square(530, 622, "src/X.png");
                        box9.setX(true);
                    }
                    list.add(x);
                    turn = !turn;
                    box9.moved();
                }
            }
            circleWin = (moves[0].getCircle() && moves[1].getCircle() && moves[2].getCircle()) ||
                    (moves[3].getCircle() && moves[4].getCircle() && moves[5].getCircle()) ||
                    (moves[6].getCircle() && moves[7].getCircle() && moves[8].getCircle()) ||
                    (moves[0].getCircle() && moves[3].getCircle() && moves[6].getCircle()) ||
                    (moves[1].getCircle() && moves[4].getCircle() && moves[7].getCircle()) ||
                    (moves[2].getCircle() && moves[5].getCircle() && moves[8].getCircle()) ||
                    (moves[0].getCircle() && moves[4].getCircle() && moves[8].getCircle()) ||
                    (moves[2].getCircle() && moves[4].getCircle() && moves[6].getCircle());

            XWin = (moves[0].getX() && moves[1].getX() && moves[2].getX()) ||
                    (moves[3].getX() && moves[4].getX() && moves[5].getX()) ||
                    (moves[6].getX() && moves[7].getX() && moves[8].getX()) ||
                    (moves[0].getX() && moves[3].getX() && moves[6].getX()) ||
                    (moves[1].getX() && moves[4].getX() && moves[7].getX()) ||
                    (moves[2].getX() && moves[5].getX() && moves[8].getX()) ||
                    (moves[0].getX() && moves[4].getX() && moves[8].getX()) ||
                    (moves[2].getX() && moves[4].getX() && moves[6].getX());
            if (again) {
                if (mouseClickLocation.getX() >= 350 && mouseClickLocation.getY() >= 100 && mouseClickLocation.getX() <= 500 && mouseClickLocation.getY() <= 148) {
                    list = reset;
                    box1.reset();
                    box2.reset();
                    box3.reset();
                    box4.reset();
                    box5.reset();
                    box6.reset();
                    box7.reset();
                    box8.reset();
                    box9.reset();
                    again = false;
                }
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

