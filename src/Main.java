public class Main {

    public static void main(String[] args) {

        Bank FreedomBank = new Bank("FreedomBank");

        Account account_1 = new Account("Anastasia", "Mineeva");
        Account account_2 = new Account("Dmitriy", "Ryabinin");
        Account account_3 = new Account("Alexander", "Grubov");
        Account account_4 = new Account("Efim", "Trofimov");

        Threads thread_1 = new Threads();
        Threads thread_2 = new Threads();
        Threads thread_3 = new Threads();
        Threads thread_4 = new Threads();
        thread_1.setResources(FreedomBank, account_1, account_2, 10.0);
        thread_2.setResources(FreedomBank, account_1, account_3, 15.0);
        thread_3.setResources(FreedomBank, account_1, account_4, 5.0);
        thread_4.setResources(FreedomBank, account_4, account_2, 35.0);

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        try {
            thread_1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            thread_4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FreedomBank.printTransactionList();
    }
}






