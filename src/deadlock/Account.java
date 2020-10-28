package deadlock;

public class Account {

    private int balance = 1_0000;

    public void deposit(int amount){
        this.balance+=amount;
    }

    public void withdraw(int amount){
        this.balance-=amount;
    }

    public int getBalance(){
        return this.balance;
    }

    public static void transfer(Account accountSource, Account accountTarget, int amount){
        accountSource.withdraw(amount);
        accountTarget.deposit(amount);
    }

}
