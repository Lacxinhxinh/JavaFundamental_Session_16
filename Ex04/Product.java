package Session16.Ex01.Ex04;

public class Product {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // toString()
    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + "}";
    }
}