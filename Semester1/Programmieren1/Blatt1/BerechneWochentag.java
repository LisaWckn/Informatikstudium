/** 
 * Programm zum Aufgabenblatt 1
 * 
 * Aufgabe 1c - berechneWochentag()
 * 
 * @author Lisa Weickenmeier
 */

import java.util.Scanner;

public class BerechneWochentag {
    public static void main(String[] args){
        //first test:
        System.out.println("First test: weekday of date 3.8.1736");
        berechneWochentag(3, 8, 1736);
        //second test:
        System.out.println("\nSecond test: weekday of date 40.3.1274");
        berechneWochentag(40, 3, 1274);
        //third test:
        System.out.println("Third test: weekday of date 19.5.2074");
        berechneWochentag(19, 5, 2074);
        System.out.println("\n");


        Scanner sc = new Scanner(System.in);

        System.out.println("Gib den Tag ein:");
        int day = sc.nextInt();
        
        System.out.println("Gib den Monat ein:");
        int month = sc.nextInt();
        
        System.out.println("Gib das Jahr ein:");
        int year = sc.nextInt();

        berechneWochentag(day, month, year);

        sc.close();
        
    }

    /**
     * @method This method checks if the params are in the limits and calculated the index of the weekday.
     * @name berechneWochentag
     * @param day The day of the date should be between 1 and 31.
     * @param month The month should be between 1 and 12.
     * @param year The year should be between 1000 and 2099.
     */
    public static void berechneWochentag(int day, int month, int year){
        String weekday = "";

        int weekdayIndex = 0;

        if((day <1 || day > 31) || (month <1 || month > 12) || (year <1000 || year > 2099)){
            System.out.println("Error! Deine Eingabe ist kein valider Tag.\n");
        }else{

            int c = year/100;
            int y = year%100;

            int m = month;

            if(month == 1){
                m = 13;
            }else if(month == 2){
                m = 14;
            }

            weekdayIndex = (day + (26*(m + 1))/10 + (5*y/4) + c/4 + 5*c -1)%7;

            weekday = getWeekdayFromIndex(weekdayIndex);

        System.out.printf("Der Wochentag am %d.%d.%d war ein %s.\n", day, month, year, weekday);
        }
    }

    /**
     * @method This method transformes the index for a weekday in the matching string.
     * @param index The index of the weekday. 0 equals sunday.
     * @return Der weekday as string will be returned.
     */
    public static String getWeekdayFromIndex(int index){
        String weekday = "";

        switch(index){
            case 0: weekday = "Sonntag";
            break;
            case 1: weekday = "Montag";
            break;
            case 2: weekday = "Dienstag";
            break;
            case 3: weekday = "Mittwoch";
            break;
            case 4: weekday = "Donnerstag";
            break;
            case 5: weekday = "Freitag";
            break;
            case 6: weekday = "Samstag";
            break;
        }

        return weekday;
    }

    
}
