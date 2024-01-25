/** 
 * Programm zum Aufgabenblatt 1
 * 
 * Aufgabe 1a - zahlenZaehlen()
 * 
 * @author Lisa Weickenmeier
 */

import java.util.Scanner;

public class ZahlenZaehlen {
    public static void main(String[] args){
        //first test:
        System.out.println("First test: primenumbers between 3 and 8.");
        zahlenZaehlen(3, 8);
        //second test:
        System.out.println("Second test: primenumbers between -4 and 10.");
        zahlenZaehlen(-4, 10);
        //third test:
        System.out.println("\nThird test: primenumbers between 19 and 5.");
        zahlenZaehlen(19, 5);

        Scanner sc = new Scanner(System.in);

        System.out.print("Zahl 1: ");
        int num1 = sc.nextInt();
        System.out.print("Zahl 2: ");
        int num2 = sc.nextInt();

        zahlenZaehlen(num1, num2);

        sc.close();
    }

    /**
     * @method Checks if passed integers are positiv. Get's all primenumbers between the passed integers 
     * and prints the sum of the primenumbers.
     * @name zahlenZaehlen
     * @param {num1} Any integer that is one of the limits for the primenumbers.
     * @param {num2} The other integer as limit for the primenumbers.
      */
    public static void zahlenZaehlen(int num1, int num2){
        //integer primSum to save the sum of all primenumbers between num1 and num2
        int primSum = 0;
        //String primString to create the String with all primenumbers, so we don't have to save the primenumbers separately
        String primString = "";
        //primCount counts the primnumbers we found.
        int primCount= 0;
        //The output String will be displayed.
        String output = "";

        
        if(num1<0 || num2<0){
            System.out.print("ERROR! Negative Eingaben sind nicht erlaubt.\n");
        }else{
            if(num1>num2){
                int h = num1;
                num1 = num2;
                num2 = h;
            }

            for(int i=num1; i<=num2; i++){
                if(isPrime(i)){
                    primCount++;
                    primSum = primSum + i;
                    if(primString == ""){
                        primString = primString + i;
                    }else{
                        primString = primString +" + "+ i;
                    }
                }
            }

            output = "Summe aller Primzahlen zwischen " + num1 + " und " + num2 + ": "
            + primString + " = " + primSum +"\nAnzahl Primzahlen: " + primCount ;

            System.out.println(output + "\n");   
        }
    }

    /**
     * @method Checks if passed integer is a primenumber.
     * @name isPrime
     * @param i Integer to check.
     * @return boolean isPrime. True = i is a primenumber, false = i isn't a primenumber.
     */
    public static boolean isPrime(int i){
        boolean isPrime = true;

        if(i==0 || i==1){
            isPrime = false;
        }else{
            for(int j=2; j<i; j++){
                if((i%j)==0){
                    isPrime = false;
                }
            }
        }

        return isPrime;
    }
}
