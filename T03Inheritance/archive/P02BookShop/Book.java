package T03Inheritance.archive.P02BookShop;

public class Book {
    private String author;
    private String title;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    public void setTitle(String title) {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        String[] authorNames = author.split("\\s+");

        if (authorNames.length == 2) {
            if (Character.isDigit(authorNames[1].charAt(0))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        this.author = author;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\n" +
                "Title: %s\n" +
                "Author: %s\n" +
                "Price: %.1f\n", this.getClass().getSimpleName(),this.title, this.author, this.price);
    }
}
