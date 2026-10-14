package restaurant;
// Main class to demonstrate collaboration
public class RestaurantApp {
    public static void main(String[] args) {
        // Creating customer
        Customer customer = new Customer("Bob");
        // Changed customer name to "Bob"
        
        // Creating menu items
        MenuItem pizza = new MenuItem("Pizza", 9.99);
        MenuItem burger = new MenuItem("Burger", 6.49);
        MenuItem soda = new MenuItem("Soda", 2.99);
        // Increased all prices by $1.00
        
        // Customer adds items to their order
        customer.addToOrder(pizza);  // Collaborating with MenuItem and Order
        customer.addToOrder(burger);
        customer.addToOrder(soda);
        // Changed customer method to .addToOrder()
        
        // Customer places the order
        customer.placeOrder();  // Collaborating with Order to show order summary
    }
}
