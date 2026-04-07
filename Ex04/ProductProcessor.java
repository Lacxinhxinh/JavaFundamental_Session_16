package Session16.Ex01.Ex04;

import java.util.List;

public interface ProductProcessor {

    // Abstract method
    double calculateTotalValue(List<Product> products);

    // Static method
    static void printProductList(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        products.forEach(System.out::println);
    }

    // Default method
    default boolean hasExpensiveProduct(List<Product> products) {
        return products.stream()
                .anyMatch(p -> p.getPrice() > 100);
    }
}