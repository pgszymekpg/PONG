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

public class Gameplay extends JPanel{
    static Ball ball;
    static Racket player1;
    static Racket player2;
    Score score;
    Quiz quiz;
    Menu menu;
    StartScreen start;
    EndScreen end;
    boolean gameStarted;
    static boolean menuChosen;
    static boolean quizStarted;
    static boolean gameOver;
    public Gameplay(){
        ball = new Ball(600,422,2,2,2,25);
        player1 = new Racket(0,372,1);
        player2 = new Racket(1246,372,2);
        score = new Score();
        quiz = new Quiz();
        start = new StartScreen();
        end = new EndScreen();
        menu = new Menu();
        gameStarted = false;
        quizStarted = false;
        menuChosen = false;
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Listener());
        this.addMouseListener(new MouseListener());
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,1280,1024);
        if (gameStarted) {
            if (quizStarted) {
                if (gameOver) {
                    end.paint(g);
                }else{
                    quiz.paint(g);
                }
            }else{
                if(menuChosen) {
                    menu.paint(g);
                }else{
                    g.setColor(Color.white);
                    g.drawLine(610,0,610,1024);
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
        winCondition(0,1247,score);
    }
    public void winCondition(int leftside, int rightside,Score score){
        if (score.score1 == 10 || score.score2 == 10) {
            quizStarted = true;
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
        ball = new Ball(600,422,2,2,2,25);
        player1 = new Racket(0,372,1);
        player2 = new Racket(1246,372,2);
    }
    public static void soundFile(File f){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(f);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }catch (Exception e) {

        }

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
                soundFile(new File("src\\sounds\\whistle.wav"));
                gameStarted = true;
            }
            if(menuChosen) {
                menu.mouseClicked(e);
            }
            if(quizStarted) {
                quiz.mouseClicked(e);
            }
            if(gameOver) {
                end.mouseClicked(e);
            }
        }
    }
}
