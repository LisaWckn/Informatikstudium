/**
 * Program for task sheet 8
 * 
 * Exercise 8b - Shopping
 * 
 * This is the Article class. The test class can be found in ShoppingTest.java.
 * Further classes for this task can be found in the files ShoppingCart.java, Book.java, Clothing.java and DVD.java.
 * 
 * @author Lisa Weickenmeier
 */

/**
 * In this class are only a constructor and simple getter methods.
 */

public class Article {
    private int articleNumber;
    private double netPrice; 

    public Article(int articleNumber, double netPrice){
        this.articleNumber = articleNumber;
        this.netPrice = Math.round(netPrice * 100.0) / 100.0;
    }

    public double getPrice(){
        return netPrice;
    }

    public int getArticleNumber(){
        return articleNumber;
    }

    public String getInfo(){
        return "";
    }
}