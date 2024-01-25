/** 
 * Programm zum Aufgabenblatt 2
 * 
 * Aufgabe 2c - Tiere und Pflanzen
 * 
 * This is only the testclass. The animals could be find in Tier.java and the plants in Pflanze.java.
 * 
 * @author Lisa Weickenmeier
 */

public class BioTest {
    public static void main(String[] args){
        Pflanze gras = new Pflanze();
        gras.setName("Gras");
        gras.setDescription("grün");
        Pflanze beeren = new Pflanze();
        beeren.setName("Beeren");
        beeren.setDescription("rot");
        Pflanze algen = new Pflanze();
        algen.setName("Algen");
        algen.setDescription("grün");

        Tier fische = new Tier();
        fische.setName("Fische");
        fische.setVegetableFood(algen);

        Tier zebra = new Tier();
        zebra.setName("Zebra");
        zebra.setVegetableFood(gras);

        Tier loewe = new Tier();
        loewe.setName("Löwe");
        loewe.setMeatFood(zebra);

        Tier baer = new Tier();
        baer.setName("Bär");
        baer.setMeatFood(fische);
        baer.setVegetableFood(beeren);

        zebra.printAnimalData();
        loewe.printAnimalData();
        baer.printAnimalData();
    }
}
