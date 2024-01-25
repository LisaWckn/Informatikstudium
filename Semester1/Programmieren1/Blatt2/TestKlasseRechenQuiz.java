/** 
 * Programm zum Aufgabenblatt 2
 * 
 * Aufgabe 2b - RechenQuiz
 * 
 * This is only the testclass. The RechenQuiz could be find in RechenQuiz.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class TestKlasseRechenQuiz {
    public static void main(String[] args){
        RechenQuiz quiz = new RechenQuiz();
        quiz.getExercise();
        int result = quiz.getResult();
        System.out.println("Result: " + result);
    }
}
