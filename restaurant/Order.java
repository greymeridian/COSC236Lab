package restaurant;
// Order class
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items = new ArrayList<>();
    
    public void addItem(MenuItem item) {
        items.add(item);
    }
    
    public double calculateTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void printOrderDetails() {
        System.out.println("Order Details:");
        for (MenuItem item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

