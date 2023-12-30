import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
/**
 * Klasa formująca ekran końcowy gry, implementująca interfejs MouseListener
 * @author Szymon Samek
 */
public class EndScreen implements MouseListener {
    /**
     * Metoda wyświetlająca zawartość ekranu końcowego
     * @param g
     */
    public void paint(Graphics g){
        //Gracz 1 wygrał
        if (Score.score1 == 10) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 60));
            g.drawString("Wrong Answer, Player 1 won!", 140, 50);
        }
        //Gracz 2 wygrał
        else if (Score.score2 == 10){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 60));
            g.drawString("Wrong Answer, Player 2 won!", 140, 50);
        }
        //Opcje rozpoczęcia na nowo lub wyjścia
        g.setFont(new Font("Courier New", Font.PLAIN, 60));
        g.drawString("Restart", 515, Const.SCREEN_HEIGHT/2);
        g.drawString("Quit", 515, (Const.SCREEN_HEIGHT/2)+100);
    }//end paint()
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
        //Sprawdzenie czy kursor znajduje się w obszarze opcji "Restart"
        if (mouseOver(mouseX, mouseY, Const.SCREEN_HEIGHT/2)) {
            //Reset wyników
            Score.score1 = 0;
            Score.score2 = 0;
            Gameplay.newRound(); //Rozpoczęcie nowej rundy
            //Reset flag przegranej oraz rozpoczęcia quizu
            Gameplay.gameOver = false;
            Gameplay.quizStarted = false;
            Gameplay.soundFile(new File("src\\sounds\\whistle.wav")); //odtworzenie dźwięku rozpoczynającego
        }
        //Sprawdzenie czy kursor znajduje się w obszarze opcji "Quit"
        else if (mouseOver(mouseX, mouseY, (Const.SCREEN_HEIGHT/2)+100)) {
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
}//end class EndScreen
