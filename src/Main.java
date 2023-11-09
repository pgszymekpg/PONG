import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JFrame frame = new JFrame("Pong");
    public static void main(String[] args) {
        Gameplay game = new Gameplay();
        frame.setSize(Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);
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
