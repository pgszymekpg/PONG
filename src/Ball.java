import java.awt.*;
/**
 * Klasa formująca ruszającą się piłkę
 * @author Szymon Samek
 */
public class Ball {
    /**
     * Początkowa współrzędna x obiektu
     */
    int xCoords;
    /**
     * Początkowa współrzędna y obiektu
     */
    int yCoords;
    /**
     * Zmiana współrzędnej x obiektu
     */
    int xChange;
    /**
     * Zmiana współrzędnej y obiektu
     */
    int yChange;
    /**
     * Szerokość obiektu
     */
    int width;
    /**
     * Prędkość ruchu obiektu
     */
    double ballSpeed;
    /**
     * Konstruktor ustawiający parametry obiektu
     * @param xCoords Początkowa współrzędna x obiektu
     * @param yCoords Początkowa współrzędna y obiektu
     * @param xChange Zmiana współrzędnej x obiektu
     * @param yChange Zmiana współrzędnej y obiektu
     * @param ballSpeed Prędkość ruchu obiektu
     * @param width Szerokość obiektu
     */
    public Ball(int xCoords,int yCoords,int xChange, int yChange,double ballSpeed,int width){
        this.xCoords=xCoords;
        this.yCoords=yCoords;
        this.xChange=xChange;
        this.yChange=yChange;
        this.ballSpeed=ballSpeed;
        this.width=width;
    }//end Ball()
    /**
     * Metoda rysująca piłkę
     * @param g
     */
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval(xCoords,yCoords,width,width);
    }//end paint()
    /**
     * Metoda wyznaczająca górną i dolną granicę ekranu
     * @param tLimit Górna granica
     * @param bLimit Dolna granica
     */
    public void boundaries_top_bottom(int tLimit, int bLimit){
        if(yCoords > bLimit || yCoords < tLimit){
            yChange*=-1; //odwrócenie kierunku ruchu w pionie
        }
    }//end boundaries_top_bottom()
    /**
     * Metoda wprawiająca piłkę w ruch po dostępnym obszarze
     */
    public void move(){
        xCoords += xChange * ballSpeed; //współrzędna x zwiększona o ustaloną wielkość pomnożoną przez prędkość piłki
        yCoords += yChange * ballSpeed; //współrzędna y zwiększona o ustaloną wielkość pomnożoną przez prędkość piłki
    }//end move()
}//end class Ball