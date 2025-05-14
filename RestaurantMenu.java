import java.util.*;
class MenuItem {
    String name, description;
    double price;
    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
    public String toString() {
        return name + ": " + description + " - $" + price;
    }
}
public class RestaurantMenu {
    LinkedHashMap<String, HashMap<String, MenuItem>> menu = new LinkedHashMap<>();

    public void addItem(String category, MenuItem item) {
        menu.putIfAbsent(category, new HashMap<>());
        menu.get(category).put(item.name, item);
    }
    public void removeItem(String category, String name) {
        if (menu.containsKey(category)) {
            menu.get(category).remove(name);
        }
    }
    public void updateItem(String category, MenuItem item) {
        if (menu.containsKey(category)) {
            menu.get(category).put(item.name, item);
        }
    }
    public void displayMenu() {
        for (String category : menu.keySet()) {
            System.out.println(category.toUpperCase());
            for (MenuItem item : menu.get(category).values()) {
                System.out.println("  " + item);
            }
        }
    }
    public static void main(String[] args) {
        RestaurantMenu rm = new RestaurantMenu();
        rm.addItem("Appetizer", new MenuItem("Chicken Tikka", "Grilled chicken", 5.99));
        rm.addItem("Main Course", new MenuItem("Biryani", "Butter chicken", 15.99));
        rm.addItem("Dessert", new MenuItem("Ice Cream", "Gulab jamun", 3.99));
        rm.displayMenu();
    }
}
