import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * Klasa formująca Quiz gry, implementująca interfejs MouseListener
 * @author Szymon Samek
 */
public class Quiz implements MouseListener {
    /**
     * Tablica jednowymiarowa przechowująca pytania
     */
    String[] questions = {
            "Where was table tennis born?",
            "How many players can play table tennis?",
            "Is table tennis an Olympic sport?",
            "What is a table tennis racket made of?",
            "Do you need any special skills to play table tennis?",
            "What are the dimensions of a table tennis table?"
    };
    /**
     * Tablica dwuwymiarowa przechowująca możliwe odpowiedzi
     */
    String[][] allAnswers = {
            //A,B,C
            {"Spain","Poland","England"},
            {"6","2 or 4","only 2"},
            {"No","Yes, since 2000","Yes, since 1988"},
            {"Board attached to a circle made of plastic","A piece of stick and a sponge","A board and two special rubber linings"},
            {"Yes, you have to be able to run fast","No","Yes, you need to have a lot of strength"},
            {"9 x 5 feet and the height is 76 cm","8 x 6 feet and the height is 120 cm","5 x 5 feet and the height is 50 cm"}
    };
    /**
     * Tablica jednowymiarowa poprawnych odpowiedzi
     */
    char[] correctAnswers = {
            'C',
            'B',
            'C',
            'C',
            'B',
            'A'
    };
    /**
     * Odpowiedź wybrana przez gracza
     */
    char guess;
    /**
     * Poprawna odpowiedź na konkretne pytanie
     */
    char correctAnswer;
    /**
     * Zmienna porządkująca pytania, przypisująca im opcje odpowiedzi oraz poprawną odpowiedź
     */
    int index;
    /**
     * Metoda rysująca elementy Quizu
     * @param g
     */
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
        //Wyświetl bieżące pytanie i możliwe odpowiedzi
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier New", Font.PLAIN, 35));
        g.drawString(questions[index], 90, 150);
        g.setFont(new Font("Courier New", Font.PLAIN, 30));
        g.drawString("A. " + allAnswers[index][0], 90, 312);
        g.drawString("B. " + allAnswers[index][1], 90, 512);
        g.drawString("C. " + allAnswers[index][2], 90, 712);
    }//end paint()
    /**
     * Metoda sprawdzająca czy wybrana odpowiedź jest poprawna
     */
    public void checkAnswer() {
        correctAnswer = correctAnswers[index]; //pobranie poprawnej odpowiedzi z tablicy
        //Gdy odpowiedziano poprawnie, kontynuuj rozgrywkę i zmniejsz wynik przeciwnika o 1
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
            Gameplay.gameOver = true;//Gdy odpowiedziano źle, ustaw flagę przegranej gry
        }
        index++; //przejdź do następnego pytania
        //Gdy skończy się liczba pytań, wróć do pierwszego pytania
        if (index == questions.length){
            index = 0;
        }
    }//end checkAnswer()
    /**
     * Metoda sprawdzająca czy użytkownik najechał myszą na konkretną opcję
     * @param mouseX Aktualna współrzędna x kursora
     * @param mouseY Aktualna współrzędna y kursora
     * @param optionY Przewidywana współrzędna y danej opcji
     * @return true gdy kursor znajduje się w obszarze danej opcji
     */
    boolean mouseOver(int mouseX, int mouseY, int optionY) {
        return mouseX >= 90 && mouseX <= 1280 && mouseY >= optionY - 40 && mouseY <= optionY + 20;
    }//end mouseOver()
    /**
     * Obsługa zdarzenia kliknięcia myszy
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        //Pobranie aktualnych współrzędnych kursora
        int mouseX = e.getX();
        int mouseY = e.getY();
        //Sprawdzenie czy kursor znajduje się w obszarze odpowiedzi A
        if (mouseOver(mouseX, mouseY, 312)) {
            //Przypisz zmiennej odpowiedz A i wywołaj metodę sprawdzająca poprawną odpowiedź
            guess = 'A';
            checkAnswer();
        }
        //Sprawdzenie czy kursor znajduje się w obszarze odpowiedzi B
        else if (mouseOver(mouseX, mouseY, 512)) {
            //Przypisz zmiennej odpowiedz B i wywołaj metodę sprawdzająca poprawną odpowiedź
            guess = 'B';
            checkAnswer();
        }
        //Sprawdzenie czy kursor znajduje się w obszarze odpowiedzi C
        else if (mouseOver(mouseX, mouseY, 712)) {
            //Przypisz zmiennej odpowiedz C i wywołaj metodę sprawdzająca poprawną odpowiedź
            guess = 'C';
            checkAnswer();
        }
    }//end mouseClicked
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
}//end class Quiz
