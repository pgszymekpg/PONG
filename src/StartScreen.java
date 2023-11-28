import java.awt.*;

public class StartScreen {
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 40));
        g.drawString("Click anywhere on screen to start Pong!", 160, 300);
    }
}
