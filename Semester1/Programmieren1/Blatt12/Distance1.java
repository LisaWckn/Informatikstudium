/**
 * Program for task sheet 12
 * 
 * Exercise 12a - Lilies
 * 
 * This is the Distance1 class.
 * Further classes for this sheet can be found in the files DataHandling.java and Distance2.java.
 * 
 * @author Lisa Weickenmeier
 */

public class Distance1 extends DataHandling{

    public static void main(String[] args) {
        Distance1 dist1 = new Distance1();
        dist1.loadProcessSave("file:/C:/Users/lisaw/downloads/iris-2.data.txt");
    }

    /**
     * This method calculates the distance of type 1 between to average arrays.
     * @param average1 first array of the average values
     * @param average2 second array of the average values
     * @return distance of type 1
     */
    public double calculateDistance(double[] average1, double[] average2){
        double distance = 0;

        for(int i=0;i<average1.length;i++){
            distance += (average1[i]-average2[i])*(average1[i]-average2[i]);
        }

        distance = Math.sqrt(distance);

        return distance;
    }
}
