import java.util.ArrayList;

class MenuItem {

    protected String name;
    protected double price;
    protected int stockQuantity;
    protected ArrayList<MenuItem> items;


    public MenuItem(String name) {
        items = new ArrayList<>();
        this.name = name;
        this.price = 0.0;
        this.stockQuantity = 0;

    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    } 

    public int getStockQuantity() {
        return stockQuantity;
    }
    
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    void setStockQuantity(int quantity) {
        stockQuantity -= quantity;
    }

}
