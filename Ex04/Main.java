package Session16.Ex01.Ex04;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        // Tạo danh sách sản phẩm
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200));
        products.add(new Product("Mouse", 25));
        products.add(new Product("Keyboard", 80));
        products.add(new Product("Monitor", 300));

        ProductProcessor processor = new ProductProcessorImpl();

        // Predicate lọc sản phẩm > 100
        Predicate<Product> expensiveFilter = p -> p.getPrice() > 100;

        // Kiểm tra sản phẩm đắt
        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Có sản phẩm đắt tiền (>100):");
            products.stream()
                    .filter(expensiveFilter)
                    .forEach(System.out::println);
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        // Tính tổng giá trị
        double total = processor.calculateTotalValue(products);
        System.out.println("\nTổng giá trị sản phẩm: " + total);

        // In danh sách
        System.out.println("\nDanh sách sản phẩm:");
        ProductProcessor.printProductList(products);
    }
}