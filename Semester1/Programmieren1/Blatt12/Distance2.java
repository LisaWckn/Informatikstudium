/**
 * Program for task sheet 12
 * 
 * Exercise 12a - Lilies
 * 
 * This is the Distance2 class.
 * Further classes for this sheet can be found in the files DataHandling.java and Distance1.java.
 * 
 * @author Lisa Weickenmeier
 */

public class Distance2 extends DataHandling{
    public static void main(String[] args) {
        Distance2 dist2 = new Distance2();
        dist2.loadProcessSave("file:/C:/Users/lisaw/downloads/iris-2.data.txt");
    }

    /**
     * This method calculates the distance of type 2 between to average arrays.
     * @param average1 first array of the average values
     * @param average2 second array of the average values
     * @return distance of type 2
     */
    public double calculateDistance(double[] average1, double[] average2){
        double distance = 0;

        for(int i=0;i<average1.length;i++){
            distance += Math.abs(average1[i]-average2[i]);
        }

        return distance;
    }
}
