/** 
 * Programm zum Aufgabenblatt 2
 * 
 * Aufgabe 2c - Tiere und Pflanzen
 * 
 * This is the animal class. The Test class could be find in BioTest.java and the plant class in Pflanze.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class Tier {
    private String name = "";
    private String vegetableFood = "-";
    private String meatFood = "-";
    private String feeder = "";

    /**
     * @method Setter method for private String name.
     * @name setName
     * @param n The name for the animal.
     */
    public void setName(String n){
        name = n;
    }

    /**
     * @method Getter method for private String name.
     * @name getName
     * @return The name of the animal as String.
     */
    public String getName(){
        return name;
    }

    /**
     * @method Setter method for the vegetable food.
     * @name setVegetableFood
     * @param v The plant that is eaten by the animal.
     */
    public void setVegetableFood(Pflanze v){
        vegetableFood = v.getName();
        if(meatFood == "-"){
            feeder = "Pflanzenfresser";
        }else{
            feeder = "Allesfresser";
        }
    }

    /**
     * @method Setter method for the meat food.
     * @name setMeatFood
     * @param m The animal that is eaten by the animal.
     */
    public void setMeatFood(Tier m){
        meatFood = m.getName();
        if(vegetableFood == "-"){
            feeder = "Fleischfresser";
        }else{
            feeder = "Allesfresser";
        }
    }

    /**
     * @method Public method to print the animal name and his food category.
     * @name printAnimalData
     */
    public void printAnimalData(){
        System.out.println(name + " ist ein " + feeder + ".");
    }
    
}
