import java.util.Scanner;

//Bank Account class
class BankAccount {
    private double balance;
    public BankAccount(double initBalance){
        balance = initBalance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public boolean withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount acc;

    public ATM(BankAccount bankAccount) {
        acc = bankAccount;
    }

    public void displayMenu() {
        System.out.println("WELCOME TO ATM MENU:");
        System.out.println("1. Check Balance :");
        System.out.println("2. Deposit :");
        System.out.println("3. Withdraw :");
        System.out.println("4. Exit !");
    }

    public void runCard() {
        Scanner scan = new Scanner(System.in);

    while (true) {
        displayMenu();
        System.out.print("Select an option: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
               System.out.println("Your Account Balance: Rs." + acc.getBalance());
               break;
            case 2:
               System.out.print("Enter amount to deposit: ");
               double depositAmount = scan.nextDouble();
               acc.deposit(depositAmount);
               System.out.println("Deposit successful." + "/n" + "Your balance: Rs." + acc.getBalance());
               break;
            case 3:
               System.out.print("Enter amount to withdraw: ");
               double withdrawAmount = scan.nextDouble();
               if (acc.withdraw(withdrawAmount)) {
                    System.out.println("Withdrawal successful. Your balance: Rs. " + acc.getBalance());
               } else {
                   System.out.println("Insufficient balance.");
               }
               break;
            case 4:
               System.out.println("***Thank you for using the ATM!***");
               scan.close();
               return;
               default:
               System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.runCard();
    }
}
