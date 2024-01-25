/** 
 * Programm zum Aufgabenblatt 1
 * 
 * Aufgabe 1b - filterMesswerte()
 * 
 * @author Lisa Weickenmeier
 */

import java.util.Scanner;

public class FilterMesswerte {
    public static void main(String[] args){
        filterMesswerte();
    }

    /**
     * @method This method keeps entering numbers until the cancel sequence is entered. 
     * The input is formatted for output according to the specified rules.
     * @name filterMesswerte
     */
    public static void filterMesswerte(){
        Scanner sc = new Scanner(System.in);

        //counterMinusOne counts the entered "-1", if another integer will be entered, counterMinusOne restarts at 0
        int counterMinusOne = 0;

        //lastValueNull will set true, if a 0 is inserted. If another integer will be inserted, lastValueNull will set false.
        boolean lastValueNull = false;

        //The output String will be displayed.
        String output = "";

        System.out.println("Gib ganze Zahlen ein: ");

        while (counterMinusOne<3){
            int readInt = sc.nextInt();
            if(readInt == -1){
                counterMinusOne++;
            }else{
                counterMinusOne = 0;
            }
            if(readInt == 0 && lastValueNull==false){
                output = output + readInt + " ";
                lastValueNull = true;
            }
            if(readInt > 0){
                output = output + readInt + " ";
                lastValueNull = false;
            }
        }

        System.out.println(output);

        sc.close();
    }
}
