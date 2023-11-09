import java.awt.*;

public class Quiz {
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 60));
        g.drawString("Game Over", (Const.SCREEN_WIDTH / 2) - 150, (Const.SCREEN_HEIGHT / 2)-50);
    }
}
