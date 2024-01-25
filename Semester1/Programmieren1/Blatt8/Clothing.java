/**
 * Program for task sheet 8
 * 
 * Exercise 8b - Shopping
 * 
 * This is the Clothing class a subclass of the Article Class. The test class can be found in ShoppingTest.java.
 * Further classes for this task can be found in the files ShoppingCart.java, Article.java, Book.java and DVD.java.
 * 
 * @author Lisa Weickenmeier
 */

public class Clothing extends Article{
    private String type;
    private String size;
    private String color;
    private final double VAT = 0.12;

    public Clothing(int articleNumber, double netPrice, String type, String size, String color){
        super(articleNumber, netPrice);
        this.type = type;
        this.size = size;
        this.color = color;
    }

    /**
     * Method to get the gross price of the clothes.
     */
    public double getPrice(){
        double grossPrice = super.getPrice() * (1+VAT);
        return grossPrice;
    }

    /**
     * Method to get all infos (type, color, size and gross price) of the clothes.
     */
    public String getInfo(){
        String info = "Clothing - " + type + ", " + color + " (" + size +") : " + this.getPrice() + " Euro";
        return info;
    }
}
