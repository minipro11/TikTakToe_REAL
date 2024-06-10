import javax.swing.*;
public class MainFrame implements Runnable {
    private GraphicsPanel panel;

    public MainFrame() {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocation(0, 0);

        panel = new GraphicsPanel();
        frame.add(panel);

        frame.setVisible(true);

        Thread thread = new Thread(this);
        thread.start();
    }
    public void run() {
        while (true) {
            panel.repaint();  // we don't ever call paintComponent directly
        }
    }
}//
