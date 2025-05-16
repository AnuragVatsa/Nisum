import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Product {
    Connection conn;
    Product(Connection conn) {
        this.conn = conn;
    }

    List<Product> searchProducts(String category, Double minPrice, Double maxPrice) {
        List<Product> products = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM products WHERE 1=1");
        List<Object> params = new ArrayList<>();
        if (category != null && !category.isEmpty()) {
            query.append(" AND category = ?");
            params.add(category);
        }
        if (minPrice != null) {
            query.append(" AND price >= ?");
            params.add(minPrice);
        }
        if (maxPrice != null) {
            query.append(" AND price <= ?");
            params.add(maxPrice);
        }

        try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error searching products: " + e.getMessage());
        }
        return products;
    }
}

// Product class for mapping
class Prod {
    private int id;
    private String name;
    private String category;
    private double price;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}