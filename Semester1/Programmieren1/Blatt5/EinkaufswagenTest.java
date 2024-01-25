/**
 * Programm zum Aufgabenblatt 5
 * 
 * Aufgabe 5b - Einkaufswagen
 * 
 * This is the test class. The Einkaufswagen class could be find in Einkaufswagen.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class EinkaufswagenTest {
    public static void main(String[] args) {
        Einkaufswagen cart = new Einkaufswagen();
        cart.addToCart("Birne");
        cart.addToCart("Salat");
        cart.addToCart("Paprika");
        cart.addToCart("Birne");
        cart.showContent();
        cart.removeFromCard("Salat");
        cart.showContent();
        System.out.println("Cart size: "+ cart.size());
        cart.removeFromCard("Pizza");
        cart.addToCart("Pizza");
        cart.addToCart("Eis");
        cart.showContent();
        cart.addToCart("Brot");
        cart.showContent();
        System.out.println("Cart size: "+ cart.size());
    }
}
