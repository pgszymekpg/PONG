import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Okno główne gry .
 * @author Szymon Samek
 */
public class Main {
    /**
     * Tworzenie obiektu JFrame o nazwie "Pong" dla reprezentacji głównego okna gry.
     */
    static JFrame frame = new JFrame("Pong");
    /**
     * Metoda tworząca głowne okno gry i uruchamiająca gre
     * @param args
     */
    public static void main(String[] args) {
        Gameplay game = new Gameplay(); //utwórz obiekt klasy Gameplay zarządzający logiką gry
        frame.setSize(Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT); //ustaw wymiary okna
        frame.setResizable(false); //blokuj możliwość zmiany rozmiaru okna
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //zamknięcie głównego okna powoduje zakończenie działania aplikacji
        frame.add(game); // dodaj obiekt klasy Gameplay do okna głownego
        frame.setVisible(true); //ustaw głowne okno jako widoczne dla użytkownika
        frame.setLocationRelativeTo(null); //wyśrodkuj głowne okno na ekranie

        // Pętla gry - utworzenie obiektu klasy Timer odświeżającego ekran gry co 7 ms
        Timer refresh_screen = new Timer(7,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.repaint(); //wywołanie metody repaint()
            }
        });
        //uruchomienie odświeżania ekranu
        refresh_screen.start();
    }//end main()
}//end class Main
