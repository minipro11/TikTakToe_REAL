
import javax.swing.*;




public class MainFrame implements Runnable {
    private GraphicsPanel panel;




    public MainFrame() {
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLocation(100, 50);




        // create and add panel
        panel = new GraphicsPanel();
        frame.add(panel);




        // display the frame
        frame.setVisible(true);




        // start thread, required for animation
        Thread thread = new Thread(this);
        thread.start();
    }




    // Runnable interface method
    public void run() {
        while (true) {
            panel.repaint();  // we don't ever call paintComponent directly
        }
    }
}
