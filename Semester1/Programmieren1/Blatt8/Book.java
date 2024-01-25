/**
 * Program for task sheet 8
 * 
 * Exercise 8b - Shopping
 * 
 * This is the Book class a subclass of the Article Class. The test class can be found in ShoppingTest.java.
 * Further classes for this task can be found in the files ShoppingCart.java, Article.java, Clothing.java and DVD.java.
 * 
 * @author Lisa Weickenmeier
 */

public class Book extends Article{
    private String author;
    private String bookTitle;
    private int yearOfRelease;
    private final double VAT = 0.07;

    public Book(int articleNumber, double netPrice, String author, String booktitle, int yearOfRelease){
        super(articleNumber, netPrice);
        this.author = author;
        this.bookTitle = booktitle;
        this.yearOfRelease = yearOfRelease;
    }

    /**
     * Method to get the gross price of the book.
     */
    public double getPrice(){
        double grossPrice = super.getPrice() * (1+VAT);
        return grossPrice;
    }

    /**
     * Method to get all infos (author, booktitle, year of release and gross price) of the book.
     */
    public String getInfo(){
        String info ="Book - " + author + ", " + bookTitle + " (" + yearOfRelease +") : " + this.getPrice() + " Euro";
        return info;
    }
}
