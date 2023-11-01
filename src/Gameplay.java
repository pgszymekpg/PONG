import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Gameplay extends JPanel{
    Ball ball;
    Racket player1;
    Racket player2;
    public Gameplay(){
        ball = new Ball((Const.SCREEN_WIDTH/2)-Const.BALL_WIDTH,(Const.SCREEN_HEIGHT/2)-Const.BALL_WIDTH,3,3,3,Const.BALL_WIDTH);
        player1 = new Racket(0,(Const.SCREEN_HEIGHT/2)-Const.RACKET_HEIGHT,1);
        player2 = new Racket(Const.SCREEN_WIDTH-Const.RACKET_WIDTH-14,(Const.SCREEN_HEIGHT/2)-Const.RACKET_HEIGHT,2);
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Listener());
    }
    public void refresh(){
        ball.boundaries(0,755);
        ball.move();
        player1.boundaries_top_bottom(0,655);
        player2.boundaries_top_bottom(0,655);
        player1.boundaries_ball(ball);
        player2.boundaries_ball(ball);
        player1.move();
        player2.move();

    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);
        ball.paint(g);
        player1.paint(g);
        player2.paint(g);
    }

    public class Listener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player1.W_S_UP_DOWN_PRESSED(e);
            player2.W_S_UP_DOWN_PRESSED(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            player1.W_S_UP_DOWN_RELEASED(e);
            player2.W_S_UP_DOWN_RELEASED(e);
        }
    }
}
