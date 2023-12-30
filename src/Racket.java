import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
/**
 * Klasa formująca ruszające się paletki
 * @author Szymon Samek
 */
public class Racket{
    /**
     * Początkowa współrzędna x obiektu
     */
    int xCoords;
    /**
     * Początkowa współrzędna y obiektu
     */
    int yCoords;
    /**
     * Prędkość ruchu obiektu w pionie
     */
    int ySpeed;
    /**
     * Identyfikator gracza
     */
    int id;
    /**
     * Flaga odbicia piłki od paletki
     */
    boolean ballHit = false;
    /**
     * Konstruktor ustawiający parametry obiektu
     * @param xCoords Początkowa współrzędna x obiektu
     * @param yCoords Początkowa współrzędna y obiektu
     * @param id Identyfikator gracza
     */
    public Racket(int xCoords,int yCoords,int id){
        this.xCoords=xCoords;
        this.yCoords=yCoords;
        this.id=id;
    }//end Racket()
    /**
     * Metoda rysująca paletkę
     * @param g
     */
    public void paint(Graphics g){
        if(id==1){
            g.setColor(Color.CYAN);
            g.fillRect(xCoords,yCoords,Const.RACKET_WIDTH,Const.RACKET_HEIGHT);
        }
        else if(id==2){
            g.setColor(Color.GREEN);
            g.fillRect(xCoords,yCoords,Const.RACKET_WIDTH,Const.RACKET_HEIGHT);
        }
    }//end paint()
    /**
     * Metoda zwiększająca prędkośc ruchu paletki w zależności od naciśniętego przycisku
     * @param e
     */
    public void W_S_UP_DOWN_PRESSED(KeyEvent e){
        if(id==1){
            //Gdy kliknięto W rusz paletką do góry, gdy kliknięto S rusz paletką w dół
            if(e.getKeyCode()==KeyEvent.VK_W){
                ySpeed = -15;
            }
            if(e.getKeyCode()==KeyEvent.VK_S){
                ySpeed = 15;
            }
        }
        else if(id==2){
            //Gdy kliknięto strzałkę do góry rusz paletką do góry, gdy kliknięto strzałkę w dół rusz paletką w dół
            if(e.getKeyCode()==KeyEvent.VK_UP){
                ySpeed = -15;
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                ySpeed = 15;
            }
        }
    }//end W_S_UP_DOWN_PRESSED()
    /**
     * Metoda zatrzymująca paletkę gdy przycisk zostanie puszczony
     * @param e
     */
    public void W_S_UP_DOWN_RELEASED(KeyEvent e){
        if(id==1){
            //Gdy puszczono W lub S zatrzymaj paletkę
            if(e.getKeyCode()==KeyEvent.VK_W){
                ySpeed = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_S){
                ySpeed = 0;
            }
        }
        else if(id==2){
            //Gdy puszczono strzałke do góry lub w dół zatrzymaj paletkę
            if(e.getKeyCode()==KeyEvent.VK_UP){
                ySpeed = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                ySpeed = 0;
            }
        }
    }//end W_S_UP_DOWN_RELEASED()
    /**
     * Metoda wyznaczająca górną i dolną granicę ekranu
     * @param tLimit Górna granica
     * @param bLimit Dolna granica
     */
    public void boundaries_top_bottom(int tLimit, int bLimit){
        if(yCoords > bLimit){
            yCoords = bLimit;
        }
        if(yCoords < tLimit){
            yCoords = tLimit;
        }
    }//end boundaries_top_bottom()
    /**
     * Metoda obijająca piłkę od paletki
     * @param ball obiekt klasy Ball
     */
    public void boundaries_ball(Ball ball) {
        //Czy koordynaty (x,y) piłki zawierają się między koordynatami (x,y) paletki oraz nie zarejestrowano odbicia piłki od paletki
        if (!ballHit && ball.xCoords + ball.width  >= xCoords && ball.xCoords  <= xCoords + Const.RACKET_WIDTH) {
            if (ball.yCoords + ball.width >= yCoords && ball.yCoords  <= yCoords + Const.RACKET_HEIGHT) {
                ballHit = true; //ustaw flagę odbicia piłki od paletki
                ball.xChange *= -1; //zmiana znaku koordynatów piłki z (x,y) na (-x,y)
                ball.ballSpeed +=0.6; //zwiększenie prędkości piłki
                Gameplay.soundFile(new File("src\\sounds\\pingpong1.wav")); //wywołanie metody odtwarzającej dźwięk odbitej piłki od paletki
            }
        }
        else {
            ballHit = false; //reset flagi obicia piłki od paletki
        }
    }//end boundaries_ball()
    /**
     * Metoda wprawiająca paletkę w ruch
     */
    public void move(){
        yCoords+=ySpeed;
    }//end move
}//end class Racket

