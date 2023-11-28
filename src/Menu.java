import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class Menu implements MouseListener {

    public Menu() {
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 80));
        g.drawString("Menu", 515, 212);
        g.setFont(new Font("Courier New", Font.PLAIN, 60));
        g.drawString("Resume", 515, 412);
        g.drawString("Restart", 515, 512);
        g.drawString("Quit", 515, 612);
    }

    public void ESC_PRESSED(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Gameplay.menuChosen = true;
        }
    }
    boolean mouseOver(int mouseX, int mouseY, int optionY) {
        if (mouseX >= 515 && mouseX <= 765 && mouseY >= optionY - 40 && mouseY <= optionY + 20){
            return true;
        }
        return false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseOver(mouseX, mouseY, 412)) {
            Gameplay.menuChosen = false;
        }
        else if (mouseOver(mouseX, mouseY, 512)) {
            Score.score1 = 0;
            Score.score2 = 0;
            Gameplay.newRound();
            Gameplay.menuChosen = false;
            Gameplay.soundFile(new File("src\\sounds\\whistle.wav"));
        }
        else if (mouseOver(mouseX, mouseY, 612)) {
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