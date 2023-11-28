import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;


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
            g.fillRect(xCoords,yCoords,20,130);
        }
        else if(id==2){
            g.setColor(Color.GREEN);
            g.fillRect(xCoords,yCoords,20,130);
        }
    }

    public void W_S_UP_DOWN_PRESSED(KeyEvent e){
        if(id==1){
            if(e.getKeyCode()==KeyEvent.VK_W){
                ySpeed = -15;
            }
            if(e.getKeyCode()==KeyEvent.VK_S){
                ySpeed = 15;
            }
        }
        else if(id==2){
            if(e.getKeyCode()==KeyEvent.VK_UP){
                ySpeed = -15;
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
                ySpeed = 15;
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
    public void boundaries_top_bottom(int tLimit, int bLimit){
        if(yCoords > bLimit){
            yCoords = bLimit;
        }
        if(yCoords < tLimit){
            yCoords = tLimit;
        }
    }
    public void boundaries_ball(Ball ball) {
        if (ball.xCoords + ball.width  >= xCoords && ball.xCoords  <= xCoords + 20) {
            if (ball.yCoords + ball.width >= yCoords && ball.yCoords  <= yCoords + 130) {
                ball.ballSpeed +=0.2;
                ball.xChange *= -1;
                Gameplay.soundFile(new File("src\\sounds\\pingpong1.wav"));
            }
        }
    }
    public void move(){
        yCoords+=ySpeed;
    }
}

