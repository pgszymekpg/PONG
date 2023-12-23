import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
/**
 * Klasa formująca główną logikę gry, dziedzicząca po klasie JPanel
 * @author Szymon Samek
 */
public class Gameplay extends JPanel{
    /**
     * Obiekt klasy Ball
     */
    static Ball ball;
    /**
     * Obiekt klasy Racket - Gracz 1
     */
    static Racket player1;
    /**
     * Obiekt klasy Racket - Gracz 2
     */
    static Racket player2;
    /**
     * Obiekt klasy Score
     */
    Score score;
    /**
     * Obiekt klasy Quiz
     */
    Quiz quiz;
    /**
     * Obiekt klasy Menu
     */
    Menu menu;
    /**
     * Obiekt klasy EndScreen
     */
    EndScreen end;
    /**
     * Flaga rozpoczęcia gry
     */
    boolean gameStarted;
    /**
     * Flaga wybrania menu
     */
    static boolean menuChosen;
    /**
     * Flaga rozpoczęcia quizu
     */
    static boolean quizStarted;
    /**
     * Flaga przegranej gry
     */
    static boolean gameOver;
    /**
     * Konstruktor inicializujący obiekty i ustawiający flagi
     */
    public Gameplay(){
        ball = new Ball(600,422,2,2,2,25);
        player1 = new Racket(0,372,1);
        player2 = new Racket(1260,372,2);
        score = new Score();
        quiz = new Quiz();
        end = new EndScreen();
        menu = new Menu();
        gameStarted = false;
        quizStarted = false;
        menuChosen = false;
        //obsługiwanie zdarzeń klawiatury
        this.setFocusable(true);
        this.requestFocusInWindow();
        //obiekty nasłuchujące zdarzeń myszy i klawiatury
        this.addKeyListener(new KeyListener());
        this.addMouseListener(new MouseListener());
    }//end Gameplay()
    /**
     * Metoda rysująca elementy gry w zależności od ustawionej flagi
     * @param g
     */
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1280,1024); //Narysuj tło
        if (gameStarted) {
            if (quizStarted) {
                if (gameOver) {
                    //Ekran końcowy
                    end.paint(g);
                }else{
                    //Quiz
                    quiz.paint(g);
                }
            }else{
                if(menuChosen) {
                    //Menu
                    menu.paint(g);
                }else{
                    //Rozgrywka
                    g.setColor(Color.white);
                    g.drawLine(610,0,610,1024); //Pionowa linia na srodku ekranu oddzielająca połowy graczy
                    refresh();
                    ball.paint(g);
                    player1.paint(g);
                    player2.paint(g);
                    score.paint(g);
                }
            }
        } else {
            //Ekran startowy
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 40));
            g.drawString("Click anywhere on screen to start Pong!", 160, 300);
            ball.paint(g);
            player1.paint(g);
            player2.paint(g);
            score.paint(g);
        }
    }//end paintComponent()
    /**
     * Metoda sprawdzająca warunek wygranej
     * @param leftside współrzędna x lewej krawędzi
     * @param rightside współrzędna x prawej krawędzi
     * @param score wynik jednego z graczy
     */
    public void winCondition(int leftside, int rightside,Score score){
        //Czy jeden z zawodników zdobył 10 punktów
        if (score.score1 == 10 || score.score2 == 10) {
            quizStarted = true; //ustawienie flagi powodującej przejście do quizu
        } else {
            //Czy gracz 1 nie odbił piłki
            if (ball.xCoords < leftside) {
                //inkrementacja wyniku gracza 2 i rozpoczęcie nowej rundy
                score.score2++;
                newRound();
            }
            //Czy gracz 2 nie odbił piłki
            if (ball.xCoords > rightside) {
                //inkrementacja wyniku gracza 1 i rozpoczęcie nowej rundy
                score.score1++;
                newRound();
            }
        }
    }//end winCondition()
    /**
     * Metoda odpowiadająca za aktualizowanie stanu piłki,paletek oraz warunku wygranej
     */
    public void refresh(){
        ball.boundaries_top_bottom(0,804);
        ball.move();
        player2.boundaries_ball(ball);
        player1.boundaries_ball(ball);
        player1.boundaries_top_bottom(0,694);
        player2.boundaries_top_bottom(0,694);
        player1.move();
        player2.move();
        winCondition(0,1260,score);
    }//end refresh()
    /**
     * Metoda rozpoczynające nową rundę rozgrywki
     */
    public static void newRound(){
        ball = new Ball(600,422,2,2,2,25);
        player1 = new Racket(0,372,1);
        player2 = new Racket(1260,372,2);
    }//end newRound()
    /**
     * Metoda odtwarzająca dźwięk z pliku zewnętrznego
     * @param f obiekt klasy File, ścieżka do pliku .wav
     */
    public static void soundFile(File f){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {

        }
    }//end soundFile()
    /**
     * Klasa obsługująca zdarzenia klawiatury, dziedzicząca po klasie KeyAdapter
     */
    public class KeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            //Przekazanie informacji o chęci ruszenia paletkami
            player1.W_S_UP_DOWN_PRESSED(e);
            player2.W_S_UP_DOWN_PRESSED(e);
            //Przekazanie informacji o chęci wejścia w menu
            menu.ESC_PRESSED(e);
        }//end keyPressed()
        @Override
        public void keyReleased(KeyEvent e) {
            //Przekazanie informacji o chęci zatrzymania paletek
            player1.W_S_UP_DOWN_RELEASED(e);
            player2.W_S_UP_DOWN_RELEASED(e);
        }//end keyReleaased()
    }//end class KeyListener
    /**
     * Klasa obsługująca zdarzenia myszy, dziedzicząca po klasie MouseAdapter
     */
    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            //Czy rozgrywka nie rozpoczęła sie
            if (!gameStarted) {
                //Ustaw flagę rozpoczęcia rozgrywki i odtwórz dźwięk rozpoczynający
                soundFile(new File("src\\sounds\\whistle.wav"));
                gameStarted = true;
            }
            //Czy wybrano menu
            if(menuChosen) {
                menu.mouseClicked(e); //obsługuj zdarzenia związane z menu
            }
            //Czy rozpoczął się quiz
            if(quizStarted) {
                quiz.mouseClicked(e); //obsługuj zdarzenia związane z quizem
            }
            //Czy rozgrywka zakończyła się
            if(gameOver) {
                end.mouseClicked(e); //obsługuj zdarzenia związane z ekranem końcowym
            }
        }//end mouseClicked()
    }//end class MouseListener
}//end class Gameplay
