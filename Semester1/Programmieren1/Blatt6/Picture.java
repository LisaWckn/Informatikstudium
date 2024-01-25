/**
 * Programm zum Aufgabenblatt 6
 * 
 * Aufgabe 6b,c - Picture
 * 
 * This is the Picture class. The test class could be find in PictureTest.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Picture {
    private String picDataFormat = "";
    private int picWidth = 0;
    private int picHeight = 0;
    private int picBrightness = 0;
    private int[][] picData;

    //This is the path to the folder where the pic is stored. Please change it for the tests.
    private final String FOLDERPATH = "file:/C:/Users/lisaw/downloads/";

    /**
     * This method reads the file and stores the data in the private variables of the class.
     * @param fileName the name of the pic including the datatype .pmg
     */
    public void readPic(String fileName){
        if(fileName.contains(".pgm")){
            Path picPath = Paths.get(URI.create(FOLDERPATH + fileName));
            List<String> lines = new ArrayList<>();
            try{
                lines = Files.readAllLines(picPath);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
            if(!lines.isEmpty() && lines.size()>2){
                picDataFormat = lines.get(0);

                String[] wiHe = lines.get(1).split(" ");
                picWidth = Integer.valueOf(wiHe[0]);
                picHeight = Integer.valueOf(wiHe[1]);

                picBrightness = Integer.valueOf(lines.get(2));

                picData = new int[picHeight][picWidth];

                for(int i=0;i<picHeight;i++){
                    int[] intInLines = getIntsOfLine(lines.get(i+3));
                    picData[i]= intInLines;
                }
            }
        }else{
            System.err.println("Your file isn't valid. ");
        }
    }

    /**
     * This method rotates the pic 90 degrees. If it is called multiple times, the rotation is multiplied.
     * The rotated Pic will be stored in the private variable picData and the picHeight and picWidht are adjusted.
     */
    public void rotatePic(){
        int[][] rotatedPic = new int[picWidth][picHeight];
        for(int i=0;i<picHeight;i++){
            for(int j=0;j<picWidth;j++){
                rotatedPic[picWidth-j-1][i]=picData[i][j];
            }
        }
        picData = rotatedPic;
        int oldWidth = picWidth;
        picWidth = picHeight;
        picHeight = oldWidth;
    }

    /**
     * This method creates a directory if it's necessary and stores the pic in a new file with the current date as name.
     * @param directory the name of the directory as String
     */
    public void writePic(String directory){
        Path directoryPath = Paths.get(URI.create(FOLDERPATH + directory));
        if(!Files.exists(directoryPath)){
            try{
                Files.createDirectory(directoryPath);
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        LocalDate currentDate = LocalDate.now();
        Path newPicPath = Paths.get(URI.create(FOLDERPATH + directory + "/" + currentDate + ".pgm"));
        List<String> lines = createPicDataLines();

        try{
            Files.deleteIfExists(newPicPath);
            Files.createFile(newPicPath);
            Files.write(newPicPath, (Iterable<String>) lines::iterator);
        }catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method creates an ArrayList with Strings from all private pic data for storage in a file.
     * @return List with Strings for the .pgm format
     */
    private List<String> createPicDataLines(){
        List<String> lines = new ArrayList<>();

        lines.add(picDataFormat);
        lines.add(picWidth + " " + picHeight);
        lines.add(String.valueOf(picBrightness));

        for(int[] line : picData){
            String lineString = "";
            for(int element : line){
                lineString += String.valueOf(element);
                if(element < 10){
                    lineString += "  ";
                }else{
                    lineString += " ";
                }
            }
            lines.add(lineString);
        }

        return lines;
    }

    /**
     * This method casts a line of the .pgm file to an int array.
     * @param line as String
     * @return int array with all integers of the line
     */
    private int[] getIntsOfLine(String line){
        ArrayList<Integer> intLine = new ArrayList<>();
        String[] words = line.split(" ");
        for(int i=0;i<words.length;i++){
            String w = words[i];
            if(!w.isEmpty() & isDigit(w)){
                intLine.add(Integer.valueOf(w));
            }
        }
        int[] ints = new int[intLine.size()];
        for(int i=0;i<intLine.size();i++){
            ints[i]=intLine.get(i);
        }
        return ints;
    }

    /**
     * This method checks if all characters of a string are digits.
     * @param w the string to check
     * @return true if all chars are digits, else return false
     */
    private boolean isDigit(String w){
        boolean isDigit = true;
        for(int i=0;i<w.length();i++){
            char c = w.charAt(i);
            if(!Character.isDigit(c)){
                isDigit = false;
            }
        }
        return isDigit;
    }
}
