import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        
        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 4;
        Item item3 = new Item();
        item3.name = "drip coffees";
        item3.price = 2.5;
        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 3;
    
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("John");

        

        order2.items.add(item1);
        order1.total += item1.price;


        order3.items.add(item4);
        order4.items.add(item2);

        order1.ready = true;

        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price*2;

        order2.ready = true;
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}
