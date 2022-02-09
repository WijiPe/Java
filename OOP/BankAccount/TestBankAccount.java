public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John", 100, 100);
        BankAccount account2 = new BankAccount("Jay", 50, 50);

        account1.display();
        account2.display();
        account1.depositMoney(20, 30);
        account1.display();
        account1.withdrawMoney(1000, 2);
        account1.display();
                
    }
        
}