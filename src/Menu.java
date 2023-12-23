import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
/**
 * Klasa formująca menu gry, implementująca interfejs MouseListener
 * @author Szymon Samek
 */
public class Menu implements MouseListener {
    /**
     * Metoda wyświetlająca zawartość menu
     * @param g
     */
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 80));
        g.drawString("Menu", 515, 212);
        g.setFont(new Font("Courier New", Font.PLAIN, 60));
        //Opcje wznowienia, rozpoczęcia na nowo lub wyjścia
        g.drawString("Resume", 515, 412);
        g.drawString("Restart", 515, 512);
        g.drawString("Quit", 515, 612);
    }//end paint()
    /**
     * Metoda sprawdzająca czy użytkownik nacisnął przycisk ESC
     * @param e
     */
    public void ESC_PRESSED(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Gameplay.menuChosen = true; //ustawienie flagi wybrania menu
        }
    }//end ESC_PRESSED()
    /**
     * Metoda sprawdzająca czy użytkownik najechał myszą na konkretną opcję
     * @param mouseX Aktualna współrzędna x kursora
     * @param mouseY Aktualna współrzędna y kursora
     * @param optionY Przewidywana współrzędna y danej opcji
     * @return true gdy kursor znajduje się w obszarze danej opcji
     */
    boolean mouseOver(int mouseX, int mouseY, int optionY) {
        return mouseX >= 515 && mouseX <= 765 && mouseY >= optionY - 40 && mouseY <= optionY + 20;
    }//end mouseOver()
    /**
     * Obsługa zdarzenia kliknięcia myszy
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //Pobranie aktualnych współrzędnych kursora
        int mouseX = e.getX();
        int mouseY = e.getY();
        //Sprawdzenie czy kursor znajduje się w obszarze opcji "Resume"
        if (mouseOver(mouseX, mouseY, 412)) {
            Gameplay.menuChosen = false; //Reset flagi wybrania menu
        }
        //Sprawdzenie czy kursor znajduje się w obszarze opcji "Restart"
        else if (mouseOver(mouseX, mouseY, 512)) {
            //Reset wyników
            Score.score1 = 0;
            Score.score2 = 0;
            Gameplay.newRound(); //Rozpoczęcie nowej rundy
            Gameplay.menuChosen = false; //Reset flagi wybrania menu
            Gameplay.soundFile(new File("src\\sounds\\whistle.wav"));
        }
        //Sprawdzenie czy kursor znajduje się w obszarze opcji "Quit"
        else if (mouseOver(mouseX, mouseY, 612)) {
            //Zamknięcie aplikacji
            System.exit(0);
        }
    }//end mouseClicked()
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
}//end class Menu
