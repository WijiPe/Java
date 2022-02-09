import java.util.ArrayList;

public class Order{
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
    this.name = "Guest";
    this.ready = false;
    this.items = new ArrayList<Item>();
    }

    public Order(String name){
    this.name = name;
    this.ready = false;
    this.items = new ArrayList<Item>();
    }

    public String getName(){
        return this.name;
    }

    public boolean getReady(){
        return this.ready;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setItem(ArrayList<Item> items){
        this.items = items;
    }

    public String getStatusMessage(){
        if(this.ready == true){
            return "Not ready";
        }else{
            return "It is ready!";
        }
    }

    public double getTotal(){
        double total = 0.0;
        for(Item i: this.items) {
            total += i.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.printf("Customer Name: %s\n", this.name);
        for(Item i: this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.println("Total: $" + this.getTotal());
    }

}