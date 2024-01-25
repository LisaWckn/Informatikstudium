/** 
 * Programm zum Aufgabenblatt 2
 * 
 * Aufgabe 2b - RechenQuiz
 * 
 * This is the RechenQuiz class. The Test class could be find in TestKlasseRechenQuiz.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class RechenQuiz {

    private int result = -1;

    /**
     * @method This method creates a random int operand.
     * @name getRandomOperand
     * @return int from the interval [1,20]
     */
    int getRandomOperand(){
        int operand = 1;

        double random = Math.random();

        operand = (int)(random*20+1);

        return operand;
    }

    /**
     * @method This public method creates random math exercises. If the result is positiv, the exercise will be printed.
     * @name getExercise
     */
    public void getExercise(){
        int operand1 = 1;
        int operand2 = 1;

        char operator = 43;

        while(result<0){
            operand1 = getRandomOperand();
            operand2 = getRandomOperand();

            /*To get a random operator the interval [0,1) will be splittet in three parts 
              and each part stands for another operand.*/
            double random = Math.random();
            if(random < (1.0/3)){
                result = operand1 + operand2;
                operator = 43;
            }else if(random < (2.0/3)){
                result = operand1 - operand2;
                operator = 45;
            }else{
                result = operand1 * operand2;
                operator = 42;
            }
        }

        System.out.println(operand1 + " " + operator + " " + operand2 + " = ?");

    }

    /**
     * @method This is the getter method for the result.
     * @name getResult
     * @return result of the exercise
     */
    public int getResult(){
        return result;
    }
}
