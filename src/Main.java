import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
        SCREEN_WIDTH = 1280;
        SCREEN_HEIGHT = 1024;
        BALL_WIDTH = 25;
        RACKET_WIDTH = 20;
        RACKET_HEIGHT = 130;
*/
public class Main {
    static JFrame frame = new JFrame("Pong");
    public static void main(String[] args) {
        Gameplay game = new Gameplay();
        frame.setSize(1280,1024);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        Timer refresh_screen = new Timer(7,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.repaint();
            }
        });
        refresh_screen.start();
    }

}
