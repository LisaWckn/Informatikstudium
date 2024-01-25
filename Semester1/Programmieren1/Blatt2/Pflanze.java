/** 
 * Programm zum Aufgabenblatt 2
 * 
 * Aufgabe 2c - Tiere und Pflanzen
 * 
 * This is the plant class. The Test class could be find in BioTest.java and the animal class in Tier.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class Pflanze {
    private String name = "";
    private String description = "";

    /**
     * @method Setter method for the plant name.
     * @name setName
     * @param n Name oft the plant.
     */
    public void setName(String n){
        name = n;
    }

    /**
     * @method Getter method for the plant name.
     * @name getName
     * @return Plant name as String.
     */
    public String getName(){
        return name;
    }

    /**
     * @method Setter method for the plant description.
     * @name setDescription
     * @param d Description of the plant.
     */
    public void setDescription(String d){
        description = d;
    }

    /**
     * @method Method to print the name and the description of a plant.
     * @name printPlantData
     */
    public void printPlantData(){
        System.out.println(name + " ist " + description);
    }
}
