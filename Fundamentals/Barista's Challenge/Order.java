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

    public void setName(String name){
        this.name= name;
    }

    
}