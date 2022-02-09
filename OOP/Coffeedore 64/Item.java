public class Item{
    private String name;
    private double price;
    private int index;

    public Item(){

    }

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setIndex(int i){
        this.index = i;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getIndex(){
        return this.index;
    }

}
