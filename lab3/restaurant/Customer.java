package restaurant;
// Customer class
public class Customer {
    private String name;
    private Order order;

    public Customer(String name) {
        this.name = name;
        this.order = new Order();  // Collaborating with Order class
    }

    public void addToOrder(MenuItem item) {
        order.addItem(item);  // Collaborating with Order to add items
    }

    public void placeOrder() {
        System.out.println("Customer: " + name);
        order.printOrderDetails();  // Collaborating with Order to display order details
    }
}
