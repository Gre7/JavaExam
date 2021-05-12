import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transaction {
    static private int count = 0;
    private int ID;
    static Lock lock = new ReentrantLock();

    Date date;

    private boolean resultOfTransaction;
    private String nameAccSender;
    private String nameAccRecipient;
    private int senderAccNumber;
    private int recipientAccNumber;
    private Double transferAmount;

    private Double senderInitialBalanceValue;
    private Double recipientInitialBalanceValue;

    private Double senderNewBalanceValue;
    private Double recipientNewBalanceValue;

    Transaction(Account sender, Account recipient, Double amount) {

            nameAccSender = sender.getName();
            nameAccRecipient = recipient.getName();
            senderAccNumber = sender.getNumberAcc();
            recipientAccNumber = recipient.getNumberAcc();
            transferAmount = amount;

            lock.lock();
            if (sender.balanceAcc() >= amount) {

                senderInitialBalanceValue = sender.balanceAcc();
                sender.setAccBalance(-amount);
                senderNewBalanceValue = sender.balanceAcc();

                recipientInitialBalanceValue = recipient.balanceAcc();
                recipient.setAccBalance(amount);
                recipientNewBalanceValue = recipient.balanceAcc();

                ID = ++count;
                date = new Date();

                lock.unlock();
                resultOfTransaction = true;
            }
             else {
                date = new Date();
                resultOfTransaction = false;
            }
    }

    void printShortInformation() {
        if (resultOfTransaction) {
            System.out.println(ID + " " + date + " " + nameAccSender + " transferred " + transferAmount + " dollars to " + nameAccRecipient);
        } else {
            System.out.println("The transaction № " + ID + " wasn`t completed. Insufficient funds.");
        }
    }

    void printFullInformation() {
        System.out.println("Number of transaction: " + ID + "   |   " + date);
        System.out.println("Sender's account: " + "№ " + senderAccNumber + " " + nameAccSender);
        System.out.println("Recipient's account: " + "№ " + recipientAccNumber + " " + nameAccRecipient);
        String str = String.format("%.2f", transferAmount);
        System.out.println("Transfer amount: $" + str);
        if (resultOfTransaction) {
            String str2 = String.format("%.2f", senderInitialBalanceValue);
            String str3 = String.format("%.2f", senderNewBalanceValue);
            System.out.println("Initial amount in the sender's account: $" + str2 + "   new amount in the sender's account: $" + str3);
            String str4 = String.format("%.2f", recipientInitialBalanceValue);
            String str5 = String.format("%.2f", recipientNewBalanceValue);
            System.out.println("Initial amount in the recipient's account: $" + str4 + "   new amount in the recipient's account: $" + str5);
        } else {
            System.out.println("The transaction wasn`t completed. Insufficient funds.");
        }
    }
}

