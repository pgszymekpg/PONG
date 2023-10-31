import java.awt.*;

public class Ball {
    int xCoords,yCoords,xChange,yChange,velocity,width;

    public Ball(int xCoords,int yCoords,int xChange, int yChange,int velocity,int width){
        this.xCoords=xCoords;
        this.yCoords=yCoords;
        this.xChange=xChange;
        this.yChange=yChange;
        this.velocity=velocity;
        this.width=width;

    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval(xCoords,yCoords,width,width);
    }
    public void boundaries(int tLimit, int bLimit){
        if(yCoords >= bLimit){
            yChange*=-1;
        }
        if(yCoords <= tLimit){
            yChange*=-1;
        }
        if(xCoords >= 1240){
            xChange*=-1;
        }
        if(xCoords <= 0){
            xChange*=-1;
        }
    }
    public void move(){
        xCoords += xChange;
        yCoords += yChange;
    }
}