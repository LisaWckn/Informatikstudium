/**
 * Program for task sheet 8
 * 
 * Exercise 8b - Shopping
 * 
 * This is the DVD class a subclass of the Article Class. The test class can be found in ShoppingTest.java.
 * Further classes for this task can be found in the files ShoppingCart.java, Article.java, Book.java and Clothing.java.
 * 
 * @author Lisa Weickenmeier
 */

public class DVD extends Article {
    private String filmTitle;
    private int duration; //In minutes
    private final double VAT = 0.19;

    public DVD(int articleNumber, double netPrice, String filmTitle, int duration){
        super(articleNumber, netPrice);
        this.filmTitle = filmTitle;
        this.duration = duration;
    }

    /**
     * Method to get the gross price of the DVD.
     */
    public double getPrice(){
        double grossPrice = super.getPrice() * (1+VAT);
        return grossPrice;
    }

    /**
     * Method to get all infos (filmtitle, duration and gross price) of the DVD.
     */
    public String getInfo(){
        int durationHour = (int)duration/60;
        int durationMinutes = duration % 60;
        String info = "DVD - " + filmTitle + " (" + durationHour +":"+ durationMinutes +") : " + this.getPrice() + " Euro";
        return info;
    }
    
}
