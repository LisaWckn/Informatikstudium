/**
 * Programm zum Aufgabenblatt 7
 * 
 * Aufgabe 7c - TemperatureGraph
 * 
 * This is the test class. The TemperatureGraph class could be find in TemperatureGraph.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class TemperatureGraphTest {
    public static void main(String[] args) {
        TemperatureGraph tempGraph = new TemperatureGraph(2004);

        tempGraph.addTemperature(1, 15);
        tempGraph.addTemperature(2, 14);
        tempGraph.addTemperature(3, 13);
        tempGraph.addTemperature(4, 15);
        tempGraph.addTemperature(5, 11);
        tempGraph.addTemperature(6, 11);
        tempGraph.addTemperature(7, 12);
        tempGraph.addTemperature(8, 13);
        tempGraph.addTemperature(9, 11);
        tempGraph.addTemperature(10, 12);
        tempGraph.addTemperature(11, 11);
        tempGraph.addTemperature(12, 11);

        tempGraph.printGraph();
    }
}
