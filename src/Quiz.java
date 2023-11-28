import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Quiz implements MouseListener {
    String[] questions = {
            "Where was table tennis born?",
            "How many players can play table tennis?",
            "Is table tennis an Olympic sport?",
            "What is a table tennis racket made of?",
            "Do you need any special skills to play table tennis?",
            "What are the dimensions of a table tennis table?"
    };
    String[][] allAnswers = {
            {"Spain","Poland","England"}, //england
            {"6","2 or 4","only 2"}, //2 or 4
            {"No","Yes, since 2000","Yes, since 1988"}, //Yes, since 1988
            {"Board attached to a circle made of plastic","A piece of stick and a sponge","A board and two special rubber linings"}, //A board and two special rubber linings
            {"Yes, you have to be able to run fast","No","Yes, you need to have a lot of strength"}, //No
            {"9 x 5 feet and the height is 76 cm","8 x 6 feet and the height is 120 cm","5 x 5 feet and the height is 50 cm"} //9 x 5 feet and the height is 76 cm
    };
    char[] correctAnswers = {
            'C',
            'B',
            'C',
            'C',
            'B',
            'A'
    };
    char guess;
    char correctAnswer;
    int index;

    public void paint(Graphics g){
        if (Score.score1 == 10) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 30));
            g.drawString("Player 2 lost! Click on a correct answer to keep playing.", 90, 50);
        }
        else if (Score.score2 == 10){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Courier New", Font.PLAIN, 30));
            g.drawString("Player 1 lost! Click on a correct answer to keep playing.", 90, 50);

        }
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 35));
        g.drawString(questions[index], 90, 150);
        g.setFont(new Font("Courier New", Font.PLAIN, 30));
        g.drawString("A. " + allAnswers[index][0], 90, 312);
        g.drawString("B. " + allAnswers[index][1], 90, 512);
        g.drawString("C. " + allAnswers[index][2], 90, 712);
    }
    boolean mouseOver(int mouseX, int mouseY, int optionY) {
        if (mouseX >= 90 && mouseX <= 1280 && mouseY >= optionY - 40 && mouseY <= optionY + 20){
            return true;
        }
        return false;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();

        if (mouseOver(mouseX, mouseY, 312)) {
            guess = 'A';
            checkAnswer();
        }
        else if (mouseOver(mouseX, mouseY, 512)) {
            guess = 'B';
            checkAnswer();
        }
        else if (mouseOver(mouseX, mouseY, 712)) {
            guess = 'C';
            checkAnswer();
        }
    }
    public void checkAnswer() {
        correctAnswer = correctAnswers[index];
        if (guess == correctAnswer) {
            if(Score.score1 == 10) {
                Score.score1 = 9;
                Gameplay.quizStarted = false;
            }
            else if(Score.score2 == 10) {
                Score.score2 = 9;
                Gameplay.quizStarted = false;
            }
        } else {
            Gameplay.gameOver = true;
        }
        index++;
        if (index == questions.length){
            index = 0;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
