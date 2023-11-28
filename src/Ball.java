import java.awt.*;

public class Ball {
    int xCoords,yCoords,xChange,yChange,width;
    double ballSpeed;

    public Ball(int xCoords,int yCoords,int xChange, int yChange,double ballSpeed,int width){
        this.xCoords=xCoords;
        this.yCoords=yCoords;
        this.xChange=xChange;
        this.yChange=yChange;
        this.ballSpeed=ballSpeed;
        this.width=width;

    }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillOval(xCoords,yCoords,width,width);
    }
    public void boundaries_top_bottom(int tLimit, int bLimit){
        if(yCoords > bLimit){
            yChange*=-1;
        }
        if(yCoords < tLimit){
            yChange*=-1;
        }
    }


    public void move(){
        xCoords += xChange * ballSpeed;
        yCoords += yChange * ballSpeed;
    }
}