import java.util.*;

class CafeUtil {
    public int getStreakGoal(){
        int sum = 0;
        for(int i = 0; i <= 10; i++){
            sum += 1;
        }
        return sum;
    }

        public int getStreakGoal(int numWeeks){
        int sum = 0;
        for(int i = 0; i <= numWeeks; i++){
            sum += 1;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total = 0;
        for(double price : prices){
            total += price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i =0; i<menuItems.size(); i++){
            System.out.println(i +" "+ menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s !", userName);
        System.out.printf("\nThere are %s people in front of you \n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }
}