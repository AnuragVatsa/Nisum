import java.util.*;
public class ProductInventory {

    HashMap<String, Integer> inventory = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    public void addProduct() {
        System.out.print("Enter product name: ");
        String product = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        if (inventory.containsKey(product)) {
            System.out.println("Product already exists");
        } else {
            inventory.put(product, quantity);
            System.out.println("Product added.");
        }
    }
    public void updateProduct() {
        System.out.print("Enter product name to update: ");
        String product = scanner.nextLine();
        if (inventory.containsKey(product)) {
            System.out.print("Enter new quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline
            inventory.put(product, quantity);
            System.out.println("Product quantity updated.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public void removeProduct() {
        System.out.print("Enter product name to remove: ");
        String product = scanner.nextLine();
        if (inventory.remove(product) != null) {
            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found.");
        }
    }
    public void checkStock() {
        System.out.print("Enter product name to check: ");
        String product = scanner.nextLine();
        if (inventory.containsKey(product) && inventory.get(product) > 0) {
            System.out.println("Product is in stock. Quantity: " + inventory.get(product));
        } else {
            System.out.println("Product is out of stock or does not exist.");
        }
    }
    public void displayInventory() {
        System.out.println("--- Inventory ---");
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (String product : inventory.keySet()) {
                System.out.println(product + ": " + inventory.get(product));
            }
        }
    }
    public void run() {
        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. Check Product Stock");
            System.out.println("5. Display All Products");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    removeProduct();
                    break;
                case 4:
                    checkStock();
                    break;
                case 5:
                    displayInventory();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void main(String[] args) {
        ProductInventory i = new ProductInventory();
        i.run();
    }
}
