public class CafeJava {
    public static void main(String[] args){
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Yout total is $";

        double mochaPrice = 3.5;
        double dripCoffeePrice = 4.5;
        double lattePrice = 5.5;
        double cappuccinoPrice = 6.5;
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";

        boolean isreadyOrder1 = false;
        boolean isreadyOrder2 = true;
        boolean isreadyOrder3 = true;
        boolean isreadyOrder4 = false;
        System.out.println(generalGreeting + customer1);
        System.out.println(customer1 + pendingMessage);
        if(isreadyOrder2){
            System.out.println(customer4 + readyMessage);
            System.out.println(displayTotalMessage + cappuccinoPrice);
        }
        else{
            System.out.println(customer4 + pendingMessage);
        }
        if(isreadyOrder3){
            System.out.println(customer2 + readyMessage);
            System.out.println(displayTotalMessage + lattePrice*2);
        }else{
            System.out.println(customer2 + pendingMessage);
        }

        System.out.println(displayTotalMessage + (lattePrice - dripCoffeePrice));
    }
   
}
