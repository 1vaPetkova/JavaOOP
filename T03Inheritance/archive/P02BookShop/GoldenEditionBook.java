package T03Inheritance.archive.P02BookShop;

public class GoldenEditionBook extends Book {
    public GoldenEditionBook(String author, String title, double price) {
        super(author, title, 1.3 * price);
    }
}
