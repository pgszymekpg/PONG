import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EndScreen implements MouseListener {
    public void paint(Graphics g){
        if (Score.score1 == 10) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 60));
            g.drawString("Wrong Answer, Player 1 won!", 100, 50);
        }
        else if (Score.score2 == 10){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 60));
            g.drawString("Wrong Answer, Player 2 won!", 100, 50);

        }
        g.setFont(new Font("Courier New", Font.PLAIN, 60));
        g.drawString("Restart", 515, 412);
        g.drawString("Quit", 515, 512);
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
            Score.score1 = 0;
            Score.score2 = 0;
            Gameplay.newRound();
            Gameplay.gameOver = false;
            Gameplay.quizStarted = false;
        }
        else if (mouseOver(mouseX, mouseY, 512)) {
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
