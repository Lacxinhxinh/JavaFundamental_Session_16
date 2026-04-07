package Session16.Ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ProductManager {
    private List<Product> products = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        products.add(new Product(id, name, price));
        System.out.println("Product added successfully.");
    }

    public void editProduct() {
        System.out.print("Enter id to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Product p : products) {
            if (p.id == id) {
                System.out.print("Enter new name: ");
                p.name = scanner.nextLine();
                System.out.print("Enter new price: ");
                p.price = scanner.nextDouble();
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void deleteProduct() {
        System.out.print("Enter id to delete: ");
        int id = scanner.nextInt();
        products.removeIf(p -> p.id == id);
        System.out.println("Product deleted successfully.");
    }

    public void findProduct() {
        System.out.print("Enter id to find: ");
        int id = scanner.nextInt();
        for (Product p : products) {
            if (p.id == id) {
                System.out.println(p);
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void filterProducts() {
        System.out.println("Filtered Products (Price > 100):");
        products.stream()
                .filter(p -> p.price > 100)
                .forEach(System.out::println);
    }

    public void totalValue() {
        double total = products.stream()
                .mapToDouble(p -> p.price)
                .sum();
        System.out.println("Total value of products: " + total);
    }
    public void menu() {
        while (true) {
            System.out.println("\n=== Product Management System ===");
            System.out.println("1. Add Product");
            System.out.println("2. Edit Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Find Product");
            System.out.println("5. Filter Products (Price > 100)");
            System.out.println("6. Total Value of Products");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: addProduct(); break;
                case 2: editProduct(); break;
                case 3: deleteProduct(); break;
                case 4: findProduct(); break;
                case 5: filterProducts(); break;
                case 6: totalValue(); break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}

