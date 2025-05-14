import java.util.*;

public class shoppingcart {

    ArrayList<String> Items = new ArrayList<>();
    ArrayList<Integer> Price = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();

    public void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the item name you to add: ");
        Items.add(sc.nextLine());
        System.out.println("Enter the price of the item: ");
        Price.add(sc.nextInt());
        System.out.println("Enter the quantity: ");
        quantity.add(sc.nextInt());
    }

    public void remove() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the item to remove from index: ");
        int ind = sc.nextInt();
        Items.remove(ind);
        Price.remove(ind);
        quantity.remove(ind);
    }

    public void display() {
        for (String item : Items) {
            System.out.println(item);
        }
    }

    public void Total() {
        int total = 0;
        for(int i = 0; i < Price.size(); i++) {
            total += Price.get(i)*quantity.get(i);
        }
        System.out.println(total);
    }

    public  static void main(String[] args) {
        shoppingcart cart = new shoppingcart();
        Scanner sc = new Scanner(System.in);
        System.out.println("1:Add Item");
        System.out.println("2:Remove Item");
        System.out.println("3:Display Item");
        System.out.println("4:Total Amount");
        System.out.println("0:Exit");
        while (true) {
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    cart.add();
                    break;
                case 2:
                    cart.remove();
                    break;
                case 3:
                    cart.display();
                    break;
                case 4:
                    cart.Total();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
