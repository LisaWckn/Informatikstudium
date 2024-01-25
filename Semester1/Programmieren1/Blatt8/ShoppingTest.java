/**
 * Program for task sheet 8
 * 
 * Exercise 8b - Shopping
 * 
 * This is the test class.
 * Further classes for this task can be found in the files ShoppingCart.java, Article.java, Book.java, Clothing.java and DVD.java.
 * 
 * @author Lisa Weickenmeier
 */

 public class ShoppingTest {
    public static void main(String[] args) {
        Book firstBook = new Book(1, 30, "Max Mustermann", "Java das Buch", 2011);
        Book secondBook = new Book(2, 30, "Max Mustermann", "Java noch ein Buch", 2021);

        DVD firstFilm = new DVD(3, 16, "Java: Der Film, Classic Collection", 141);

        Clothing firstClothing = new Clothing(4, 7.5, "T-shirt", "M", "blue");

        ShoppingCart myCart = new ShoppingCart();
        myCart.removeArticle(firstClothing);
        myCart.addArticle(firstBook);
        myCart.addArticle(secondBook);
        myCart.addArticle(firstFilm);
        myCart.addArticle(firstClothing);

        myCart.printShoppingCart();
    }
}
