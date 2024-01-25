/**
 * Program for task sheet 12
 * 
 * Exercise 12a - Lilies
 * 
 * This is the abstract DataHandling class.
 * Further classes for this sheet can be found in the files Distance1.java and Distance2.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

abstract class DataHandling{
    protected double[][] cluster1 = new double[50][4];
    protected double[][] cluster2 = new double[50][4];
    protected double[][] cluster3 = new double[50][4];

    /**
     * Method to load the data from the file, calculate the averages and the distances and print the results.
     * @param filePath the path to the iris-2.data.txt file
     */
    public final void loadProcessSave(String filePath){
        loadData(filePath);

        double[] average1 = calculateAverage(cluster1);
        double[] average2 = calculateAverage(cluster2);
        double[] average3 = calculateAverage(cluster3);

        double distance1 = calculateDistance(average1, average2);
        double distance2 = calculateDistance(average1, average3);
        double distance3 = calculateDistance(average2, average3);

        print(distance1, distance2, distance3);
    }

    /**
     * Abstract method to calculate the distance between two array with average data.
     * @param average1 first array of the average values
     * @param average2 second array of the average values
     * @return distance
     */
    public abstract double calculateDistance(double[] average1, double[] average2);

    /**
     * Method to calculate the average of all four columns of the cluster.
     * @param cluster with the lily data
     * @return an array with the average data
     */
    public double[] calculateAverage(double[][] cluster){
        double[] average = new double[cluster[0].length];
        int valueCount = cluster.length;
        for(int c=0;c<cluster[0].length;c++){
            for(int r=0;r<valueCount;r++){
                average[c] += cluster[r][c];
            }
            average[c] = average[c]/valueCount;
        }
        return average;
    }

    /**
     * Method to load the data from the file to the clusters.
     * @param filePath the path to the iris-2.data.txt file
     */
    public void loadData(String filePath){
        Path path = Paths.get(URI.create(filePath));
        List<String> lines = new ArrayList<>();
        try{
            lines = Files.readAllLines(path);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        if(!lines.isEmpty()){
            List<String> linesIris1 = new ArrayList<>();
            List<String> linesIris2 = new ArrayList<>();
            List<String> linesIris3 = new ArrayList<>();
            for(int i=0;i<lines.size();i++){
                if(lines.get(i).contains("Iris-setosa")){
                    linesIris1.add(lines.get(i));
                }else if(lines.get(i).contains("Iris-versicolor")){
                    linesIris2.add(lines.get(i));
                }else{
                    linesIris3.add(lines.get(i));
                }
            }
            for(int i = 0;i<linesIris1.size();i++){
                String[] line = linesIris1.get(i).split(",");
                for(int j=0;j<line.length-1;j++){
                    try{
                        cluster1[i][j] = Double.parseDouble(line[j]);
                    }catch(Exception e){
                        cluster1[i][j] = 0;
                    }
                }
            }
            for(int i = 0;i<linesIris2.size();i++){
                String[] line = linesIris2.get(i).split(",");
                for(int j=0;j<line.length-1;j++){
                    try{
                        cluster2[i][j] = Double.parseDouble(line[j]);
                    }catch(Exception e){
                        cluster2[i][j] = 0;
                    }
                }
            }
            for(int i = 0;i<linesIris3.size();i++){
                String[] line = linesIris3.get(i).split(",");
                for(int j=0;j<line.length-1;j++){
                    try{
                        cluster3[i][j] = Double.parseDouble(line[j]);
                    }catch(Exception e){
                        cluster3[i][j] = 0;
                    }
                }
            }
        }
    }

    /**
     * Method to print the distances.
     * @param distance1 distance between the averages of cluster1 and cluster2
     * @param distance2 distance between the averages of cluster1 and cluster3
     * @param distance3 distance between the averages of cluster2 and cluster3
     */
    public void print(double distance1, double distance2, double distance3){
        System.out.println("Results for Distance:");
        System.out.printf("d(cluster1, cluster2) = %.2f\n", distance1);
        System.out.printf("d(cluster1, cluster3) = %.2f\n", distance2);
        System.out.printf("d(cluster2, cluster3) = %.2f\n", distance3);
    }

}