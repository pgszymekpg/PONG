import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gameplay extends JPanel{
    static Ball ball;
    static Racket player1;
    static Racket player2;
    Score score;
    Quiz quiz;
    Menu menu;
    StartScreen start;
    boolean gameStarted;
    boolean gameOver;
    static boolean menuChosen;
    public Gameplay(){
        ball = new Ball((Const.SCREEN_WIDTH/2)-Const.BALL_WIDTH-15,(Const.SCREEN_HEIGHT/2)-3*Const.BALL_WIDTH-15,2,2,2,Const.BALL_WIDTH);
        player1 = new Racket(0,(Const.SCREEN_HEIGHT/2)-Const.RACKET_HEIGHT-10,1);
        player2 = new Racket(Const.SCREEN_WIDTH-Const.RACKET_WIDTH-14,(Const.SCREEN_HEIGHT/2)-Const.RACKET_HEIGHT-10,2);
        score = new Score();
        quiz = new Quiz();
        start = new StartScreen();
        menu = new Menu();
        gameStarted = false;
        gameOver = false;
        menuChosen = false;
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Listener());
        this.addMouseListener(new MouseListener());
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Const.SCREEN_WIDTH,Const.SCREEN_HEIGHT);
        if (gameStarted) {
            if (gameOver) {
                quiz.paint(g);
            } else {
                if(menuChosen) {
                    menu.paint(g);
                }else{
                    g.setColor(Color.white);
                    g.drawLine((Const.SCREEN_WIDTH/2)-30,0,(Const.SCREEN_WIDTH/2)-30,Const.SCREEN_HEIGHT);
                    ball.paint(g);
                    player1.paint(g);
                    player2.paint(g);
                    score.paint(g);
                    refresh();
                }
            }
        } else {
            start.paint(g);
            ball.paint(g);
            player1.paint(g);
            player2.paint(g);
            score.paint(g);
        }
    }
    public void refresh(){
        ball.boundaries_top_bottom(0,755);
        ball.move();
        player1.boundaries_ball(ball);
        player2.boundaries_ball(ball);
        player1.boundaries_top_bottom(0,655);
        player2.boundaries_top_bottom(0,655);
        player1.move();
        player2.move();
        winCondition(0,Const.SCREEN_WIDTH-Const.BALL_WIDTH,score);
    }
    public void winCondition(int leftside, int rightside,Score score){
        if (score.score1 == 10 || score.score2 == 10) {
            gameOver = true;
        } else {
            if (ball.xCoords < leftside) {
                score.score2++;
                newRound();
            }
            if (ball.xCoords > rightside) {
                score.score1++;
                newRound();
            }
        }
    }
    public static void newRound(){
        ball = new Ball((Const.SCREEN_WIDTH/2)-Const.BALL_WIDTH,(Const.SCREEN_HEIGHT/2)-Const.BALL_WIDTH,2,2,2,Const.BALL_WIDTH);
        player1 = new Racket(0,(Const.SCREEN_HEIGHT/2)-Const.RACKET_HEIGHT,1);
        player2 = new Racket(Const.SCREEN_WIDTH-Const.RACKET_WIDTH-14,(Const.SCREEN_HEIGHT/2)-Const.RACKET_HEIGHT,2);
    }
    public class Listener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            player1.W_S_UP_DOWN_PRESSED(e);
            player2.W_S_UP_DOWN_PRESSED(e);
            menu.ESC_PRESSED(e);

        }

        @Override
        public void keyReleased(KeyEvent e) {
            player1.W_S_UP_DOWN_RELEASED(e);
            player2.W_S_UP_DOWN_RELEASED(e);
        }

    }
    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (!gameStarted) {
                gameStarted = true;
            }
            menu.mouseClicked(e);
        }
    }
}
