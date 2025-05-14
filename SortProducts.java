import java.util.*;
class Product {
    String name;
    String category;
    double price;
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        int categoryComparison = p1.category.compareTo(p2.category);
        if (categoryComparison != 0) {
            return categoryComparison;
        }
        return Double.compare(p1.price, p2.price);
    }
}
public class SortProducts {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 50000));
        products.add(new Product("Apple", "Fruit", 120));
        products.add(new Product("Banana", "Fruit", 50));
        products.add(new Product("Tablet", "Electronics", 3000));
        products.add(new Product("Shirt", "Clothing", 2500));
        products.add(new Product("Pants", "Clothing", 500));
        Collections.sort(products, new ProductComparator());
        for (Product product : products) {
            System.out.println(product);
        }
    }
}