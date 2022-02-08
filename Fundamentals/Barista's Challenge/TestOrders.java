import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        

        Item item1 = new Item("cappucino", 5.5);
        Item item2 = new Item("Mocha", 6.5);
        Item item3 = new Item("Latte", 4.5);
        Item item4 = new Item("Drip Coffee", 5.0);
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("John");

        System.out.println(order3.getStatusMessage());

        order1.setName("Wiji");
        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.println(order1.getTotal());

        order3.addItem(item1);
        order3.addItem(item4);
        order3.addItem(item2);
        order3.display();
        order1.display();

    }
}
