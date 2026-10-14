package restaurant;
// MenuItem class
public class MenuItem {
    private String name;
    private double priceInDollars;

    public MenuItem(String name, double price) {
        this.name = name;
        this.priceInDollars = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return priceInDollars;
    }
}
