import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Menu implements MouseListener {

    public Menu() {
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 80));
        g.drawString("Menu", (Const.SCREEN_WIDTH / 2) - 125, (Const.SCREEN_HEIGHT / 2) - 300);
        g.setFont(new Font("Courier New", Font.PLAIN, 60));
        g.drawString("Resume", (Const.SCREEN_WIDTH / 2) - 125, (Const.SCREEN_HEIGHT / 2)-100);
        g.drawString("Restart", (Const.SCREEN_WIDTH / 2) - 125, (Const.SCREEN_HEIGHT / 2));
        g.drawString("Quit", (Const.SCREEN_WIDTH / 2) - 125, (Const.SCREEN_HEIGHT / 2) + 100);
    }

    public void ESC_PRESSED(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Gameplay.menuChosen = true;
        }
    }
    boolean mouse_over(int mouseX, int mouseY, int optionY) {
        if (mouseX >= (Const.SCREEN_WIDTH / 2) - 125 && mouseX <= (Const.SCREEN_WIDTH / 2) + 125 && mouseY >= optionY - 40 && mouseY <= optionY + 20){
            return true;
        }
        return false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouse_over(mouseX, mouseY, (Const.SCREEN_HEIGHT / 2) - 100)) {
            Gameplay.menuChosen = false;
        }
        else if (mouse_over(mouseX, mouseY, (Const.SCREEN_HEIGHT / 2))) {
            Score.score1 = 0;
            Score.score2 = 0;
            Gameplay.newRound();
            Gameplay.menuChosen = false;
        }
        else if (mouse_over(mouseX, mouseY, (Const.SCREEN_HEIGHT / 2) + 100)) {
            System.exit(0);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}