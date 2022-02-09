import java.util.ArrayList;

public class CoffeeKiosk{

    private ArrayList<Item> menu = new ArrayList<Item>();
    private ArrayList<Order> orders = new ArrayList<Order>();

    public CoffeeKiosk(){

    }
    
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        menu.add(newItem);
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
    }

    public void display(){
        for(Item  i: this.menu){
            System.out.printf("%d %s -- %.2f\n", i.getIndex(),i.getName(),i.getPrice());
        }
    }

    public void newOrder() {
        
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        
        this.display();

        Order o = new Order(name);
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        while(!itemNumber.equals("q")) {
            o.addOrder(this.menu.get(Integer.parseInt(itemNumber)));
            itemNumber = System.console().readLine();
            // Get the item object from the menu, and add the item to the order
            // Ask them to enter a new item index or q again, and take their input
        }
        o.displayOrder();

        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        
    }

    public void addMenu() {
        System.out.println("Please enter menu for new menu:");
        String name = System.console().readLine();

        while(!name.equals("q")) {
            System.out.println("Please enter price:");
            String price = System.console().readLine();
            this.addMenuItem(name, Double.parseDouble(price));
            name = System.console().readLine();
        }
        this.display();
    }

}