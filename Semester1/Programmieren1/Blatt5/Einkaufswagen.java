/**
 * Programm zum Aufgabenblatt 5
 * 
 * Aufgabe 5b - Einkaufswagen
 * 
 * This is the Einkaufswagen class. The test class could be find in EinkaufswagenTest.java.
 * 
 * @author Lisa Weickenmeier
 */

import java.util.ArrayList;

public class Einkaufswagen {
    private ArrayList<String> cart = new ArrayList<String>();
    private int limit = 5;

    /**
     * The method adds a specific item to the card, 
     * if the cardsize doesn't reach the limit 
     * and if the element isn't already in the cart.
     * @param item to be added as String
     */
    public void addToCart(String item){
        if(this.size()<limit){  
            cart.add(item);
        }else{
            System.out.println("Error! Your cart is full.");
        }
    }

    /**
     * This method removes a specific item from the cart 
     * if it is currently a shopping cart item.
     * @param item to be removed as String
     */
    public void removeFromCard(String item){
        int index = -1;
        for(int i = 0; i<this.size();i++){
            if(cart.get(i) == item){
                index = i;
            }
        }
        if (index!=-1) {
            cart.remove(index);
        }else{
            System.out.printf("Error! The item %s isn't in your cart.\n", item);
        }
    }

    /**
     * This method prints the whole shopping cart.
     */
    public void showContent(){
        System.out.print("Shopping cart: ");
        for(int i=0; i<this.size()-1;i++){
            System.out.print(cart.get(i) + ", ");
        }
        System.out.println(cart.get(this.size()-1));
    }

    /**
     * Method to get the current size of the cart.
     * @return the size of the cart as int.
     */
    public int size(){
        return cart.size();
    }
}
