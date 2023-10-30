import javax.swing.*;
import java.awt.*;

public class JFramePong extends JFrame {
    JPanelPong panel;
    JFramePong(){
        panel = new JPanelPong();
        this.add(panel);
        this.setVisible(true);
        this.setSize(1280,1024);
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Pong");
        this.setLocationRelativeTo(null);

    }
}
