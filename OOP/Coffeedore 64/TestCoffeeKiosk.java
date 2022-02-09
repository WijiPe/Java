public class TestCoffeeKiosk{
    public static void main(String[] args){
        CoffeeKiosk test = new CoffeeKiosk();
        
        test.addMenuItem("Banana", 2);
        test.addMenuItem("Coffee", 1.50);
        test.addMenuItem("Latte", 4.50);
        test.addMenuItem("Capuccino", 3);
        test.addMenuItem("Muffin", 4);

        test.display();
        test.addMenu();
        test.newOrder();
    }
}