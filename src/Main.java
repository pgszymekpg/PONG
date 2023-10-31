import javax.swing.*;

public class Main {
    public static JFrame frame = new JFrame();
    public static void main(String[] args) {
        frame.setVisible(true);
        frame.setSize(Const.SCREEN_WIDTH, Const.SCREEN_HEIGHT);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pong");
        frame.setLocationRelativeTo(null);
    }
}
