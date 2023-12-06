public class Order implements Cost {
    
    private String name;
    private int quantity;
    public double price;

    public Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.price = 0.0;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateCost(int qty) {
        return qty * getPrice();
    }

}
