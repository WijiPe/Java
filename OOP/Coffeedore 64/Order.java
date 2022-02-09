import java.util.ArrayList;

public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items = new ArrayList<Item>();

    public Order(String CustomerName){
        this.name = CustomerName;
        this.ready = false;
    }

    public void addOrder(Item item){
        items.add(item);

    }

    public void displayOrder(){
        double total = 0;
        for(Item  i: this.items){
            System.out.printf("%d %s -- %.2f\n", i.getIndex(),i.getName(),i.getPrice());
            total += i.getPrice();
        }
        System.out.printf("Total: %.2f\n", total);
    }
}