package Session16.Ex01.Ex04;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1200));
        products.add(new Product("Mouse", 25));
        products.add(new Product("Keyboard", 80));
        products.add(new Product("Monitor", 300));

        ProductProcessor processor = new ProductProcessorImpl();

        Predicate<Product> expensiveFilter = p -> p.getPrice() > 100;


        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Có sản phẩm đắt tiền (>100):");
            products.stream()
                    .filter(expensiveFilter)
                    .forEach(System.out::println);
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }


        double total = processor.calculateTotalValue(products);
        System.out.println("\nTổng giá trị sản phẩm: " + total);


        System.out.println("\nDanh sách sản phẩm:");
        ProductProcessor.printProductList(products);
    }
}