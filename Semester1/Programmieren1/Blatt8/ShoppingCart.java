/**
 * Program for task sheet 8
 * 
 * Exercise 8b - Shopping
 * 
 * This is the ShoppingCart class. The test class can be found in ShoppingTest.java.
 * Further classes for this task can be found in the files Article.java, Book.java, Clothing.java and DVD.java.
 * 
 * @author Lisa Weickenmeier
 */

 import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Article> articleList = new ArrayList<>();

    /**
     * Method to add an article to the article list.
     * @param article
     */
    public void addArticle(Article article){
        articleList.add(article);
    }

    /**
     * Method to remove an article from the article list.
     * @param article
     */
    public void removeArticle(Article article){
        articleList.remove(article);
    }

    /**
     * Method to print the whole article list and the total price of all articles in the shopping cart.
     */
    public void printShoppingCart(){
        double totalPrice = 0;
        for(int i=0;i<articleList.size();i++){
            Article currentArticle = articleList.get(i);
            System.out.println(currentArticle.getInfo());
            totalPrice += currentArticle.getPrice();
        }
        double roundTotalPrice = Math.round(totalPrice * 100.0) / 100.0;
        System.out.println("Total price: " + roundTotalPrice);
    }
}
