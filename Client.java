import java.util.ArrayList;

public class Client {

    private String name;
    private ArrayList<Order> clientOrders;

    public Client(String name) {
        this.clientOrders = new ArrayList<>();
        this.name = name;
    }

    public String getName () {
        return name;
    }

    public ArrayList<Order> getClientOrders() {
        return clientOrders;
    }

    public void clientOrder(Order order, ArrayList<MenuItem> items) throws Exception {

        for (MenuItem item : items) {
            if (item.getName().equals(order.getName())) {

                if (order.getQuantity() > item.getStockQuantity() || item.getStockQuantity() - order.getQuantity() < 0) {
                    throw new Exception("sorry, not in stock or we don't have enough");
                }
            
            clientOrders.add(order);
            item.setStockQuantity(order.getQuantity());
            order.setPrice(item.getPrice());
            System.out.println("your order was placed successfully!!!");

            } 
            
            else {
                throw new Exception("sorry, we don't have this option");
            }
        }
    }

    public String toString() {
       String ss = "";
       ss += this.getName() + ":\n";

       for (Order order : this.getClientOrders()) {
            ss += order.getName() + " $" + order.calculateCost(order.getQuantity()) + " reais\n";
       }
       
       return ss;
    }
}
