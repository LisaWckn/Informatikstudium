/**
 * Programm zum Aufgabenblatt 7
 * 
 * Aufgabe 7c - TemperatureGraph
 * 
 * This is the TemperatureGraph class. The test class could be find in TemperatureGraphTest.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class TemperatureGraph {
    private int[] temperature = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    private int year;

    /**
     * Constructor with a year as integer.
     * @param year
     */
    public TemperatureGraph(int year){
        this.year = year;
    }

    /**
     * This method adds a temperature to the array temperature.
     * The index of the array results from the month - 1.
     * @param month as integer from 1 (january) to 12 (december)
     * @param temperature positive integer
     */
    public void addTemperature(int month, int temperature){
        if(temperature >=0){
            this.temperature[month-1] = temperature;
        }else{
            System.out.println("The temperature must be positive.");
        }
    }

    /**
     * Method to print the graph if there are temperatures in the array for every month.
     */
    public void printGraph(){
        if(temperatureIsFilled() && temperature != null && temperature.length != 0){
            int min = minTemp();
            int max = maxTemp();

            System.out.println("Year: " + year);

            for(int i=max;i>min-1;i--){
                System.out.print(i + "  ");
                for(int j=0;j<temperature.length;j++){
                    if(temperature[j]>=i){
                        System.out.print("# ");
                    }else{
                        System.out.print("  ");
                    }
                }
                System.out.println("");
            }
        }else{
            System.out.println("Please insert temperatures for every month!");
        }
    }

    /**
     * Method tests whether the temperature array is completely filled which is equivalent to there being no -1 in the array.
     * @return true if array is filled, else return false
     */
    private boolean temperatureIsFilled(){
        if(temperature != null && temperature.length != 0){
            boolean isFilled = true;
            for(int i=0;i<temperature.length;i++){
                if(temperature[i]==-1){
                    isFilled = false;
                }
            }
            return isFilled;
        }else{
            return false;
        }
    }

    /**
     * Method that determines the minimum of all temperatures.
     * @return minimum as int
     */
    private int minTemp(){
        if(temperature != null && temperature.length != 0){
            int minTemp = temperature[0];
            for(int i=1;i<temperature.length;i++){
                if(temperature[i]<minTemp){
                    minTemp = temperature[i];
                }
            }
            return minTemp;
        }else{
            return -1;
        }
    }

    /**
     * Method that determines the maximum of all temperatures.
     * @return maximum as int
     */
    private int maxTemp(){
        if(temperature != null && temperature.length != 0){
            int maxTemp = temperature[0];
            for(int i=1;i<temperature.length;i++){
                if(temperature[i]>maxTemp){
                    maxTemp = temperature[i];
                }
            }
            return maxTemp;
        }else{
            return -1;
        }
    }
}
