import java.awt.*;
/**
 * Klasa formująca wyświetlanie wyników graczy
 * @author Szymon Samek
 */
public class Score {
    /**
     * Wynik gracza 1
     */
    static int score1;
    /**
     * Wynik gracza 2
     */
    static int score2;
    /**
     * Metoda wyświetlająca wyniki graczy
     * @param g
     */
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New",Font.PLAIN,60));
        g.drawString("P1 :" + String.valueOf(score1/10)+String.valueOf(score1%10) , 350, 50);
        g.drawString(String.valueOf(score2/10)+String.valueOf(score2%10) + ": P2" , 650, 50);
        g.setFont(new Font("Courier New",Font.PLAIN,30));
        g.drawString("ESC - MENU "  , 0, 20);
    }//end paint()
}//end class Score
