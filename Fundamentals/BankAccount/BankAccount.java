public class BankAccount{
    private String accountName;
    private double checking;
    private double saving;
    private static int numberOfAccount = 0;
    private static double amountOfMoney = 0;

    public BankAccount(String accountNameParam, double checkingParam, double savingParam){
        accountName = accountNameParam;
        checking = checkingParam;
        saving = savingParam;
        numberOfAccount++;
        amountOfMoney = checking+saving;
    }

    public void setItem(ArrayList<Item> items){
        this.items = items;
    }

    public String getAccountName(){
        return this.accountName;
    }

    public double getChecking(){
        return this.checking;
    }

    public double getSaving(){
        return this.saving;
    }

    public static int accountCount(){
        return numberOfAccount;
    }

    public static double moneyCount(){
        return amountOfMoney;
    }

    public void depositMoney(double checkingParam, double savingParam){
        this.checking += checkingParam;
        this.saving += savingParam;
        amountOfMoney = this.checking+this.saving;
    }

    public void display(){
        System.out.println("----------Account----------");
        System.out.printf("Account Name: %s\n", this.accountName);
        System.out.printf("Checking Balance: %s\n", this.checking);
        System.out.printf("Savinging Balance: %s\n", this.saving);
        System.out.printf("Number of Accounts: %s\n", numberOfAccount);
        System.out.printf("Amount of Money: %s\n", amountOfMoney);
    }

    public void withdrawMoney(double checkingParam, double savingParam){
        if(this.checking > checkingParam){
            this.checking -= checkingParam;
        }else{
            System.out.println("You do not have enough money in Checking Balance to withdraw!");
        }
        if(this.saving > savingParam){
            this.saving -= savingParam;
        }else{
            System.out.println("You do not have enough money Savinging Balance to withdraw!");
        }
        amountOfMoney = this.checking+this.saving;
    }

}