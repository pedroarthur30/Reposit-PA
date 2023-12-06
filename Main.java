import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        MenuItem menu = new MenuItem(null);
        Map<String, Client> clients = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Digite um comando (ou 'end' para sair):");
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            try {
                switch (command[0]) {
                    case "end":
                        System.out.println("programa finalizado!!!");
                        return;
                    case "addSnack":
                        String snackName = command[1];
                        double snackPrice = Double.parseDouble(command[2]);
                        int stockSnack = Integer.parseInt(command[3]);
                        menu.addItem(new Snack(snackName, snackPrice, stockSnack));
                        break;
                    case "addBeverage":
                        String beverageName = command[1];
                        double beveragePrice = Double.parseDouble(command[2]);
                        int stockBeverage = Integer.parseInt(command[3]);
                        menu.addItem(new Beverage(beverageName, beveragePrice, stockBeverage));
                        break;
                    case "addDessert":
                        String dessertName = command[1];
                        double dessertPrice = Double.parseDouble(command[2]);
                        int stockDessert = Integer.parseInt(command[3]);
                        menu.addItem(new Dessert(dessertName, dessertPrice, stockDessert));
                        break;
                    case "Order":
                        String clientName = command[1];
                        String itemName = command[2];
                        int quantity = Integer.parseInt(command[3]);

                        boolean exist = false;
                        for (Client cliente : clients.values()) {
                            if (cliente.getName().equals(clientName)) {
                                cliente.clientOrder(new Order(itemName, quantity), menu.getItems());
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            Client cliente = new Client(clientName);
                            clients.put(clientName, cliente);
                            cliente.clientOrder(new Order(itemName, quantity), menu.getItems());
                        }
                        break; 
                    case "showAllBill":
                        System.out.println("--------- CLient's overral bill: ---------");
                        for (Client cliente : clients.values()) {
                            System.out.println(cliente.toString());
                        }
                        break;
                    case "ClientBill":
                        String thisClient = command[1];
                        System.out.format("-------- %s bill: ---------\n", thisClient);
                        for (Client cliente : clients.values()) {
                            if (cliente.getName().equals(thisClient)) {
                                System.out.println(cliente.toString());
                            }

                            else {
                                throw new Exception ("client does not exist, sorry!!!");
                            }
                        }
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
    
        }
    }
}
























        
        