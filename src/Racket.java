import java.awt.*;
import java.awt.event.KeyEvent;

public class Racket{
    int xCoords,yCoords,ySpeed,id;


    Racket(int xCoords,int yCoords,int id){
        this.xCoords=xCoords;
        this.yCoords=yCoords;
        this.id=id;
    }
    public void paint(Graphics g){
        if(id==1){
            g.setColor(Color.CYAN);
            g.fillRect(xCoords,yCoords,Const.RACKET_WIDTH,Const.RACKET_HEIGHT);
        }
        else if(id==2){
            g.setColor(Color.GREEN);
            g.fillRect(xCoords,yCoords,Const.RACKET_WIDTH,Const.RACKET_HEIGHT);
        }
    }

    public void W_S_UP_DOWN_PRESSED(KeyEvent e){
        if(id==1){
            if(e.getKeyCode()==KeyEvent.VK_W){
                ySpeed = -10;
            }
            if(e.getKeyCode()==KeyEvent.VK_S){
                ySpeed = 10;
            }
        }
        else if(id==2){
            if(e.getKeyCode()==KeyEvent.VK_UP){
                ySpeed = -10;
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                ySpeed = 10;
            }
        }
    }
    public void W_S_UP_DOWN_RELEASED(KeyEvent e){
        if(id==1){
            if(e.getKeyCode()==KeyEvent.VK_W){
                ySpeed = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_S){
                ySpeed = 0;
            }
        }
        else if(id==2){
            if(e.getKeyCode()==KeyEvent.VK_UP){
                ySpeed = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                ySpeed = 0;
            }
        }
    }
    public void boundaries(int tLimit, int bLimit){
        if(yCoords >= bLimit){
            yCoords = bLimit;
        }
        if(yCoords <= tLimit){
            yCoords = tLimit;
        }
    }
    public void move(){
        yCoords+=ySpeed;
    }
}

