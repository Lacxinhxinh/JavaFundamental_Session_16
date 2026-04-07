package Session16.Ex01.Ex04;

import java.util.List;

public class ProductProcessorImpl implements ProductProcessor {

    @Override
    public double calculateTotalValue(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}