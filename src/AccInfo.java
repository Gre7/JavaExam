public class AccInfo {
    private int numberAcc;
    private Double money;

    AccInfo() {
        numberAcc = (int) (Math.random() * 1000000000);
        money = Math.random() * 10000;
    }

    int get_numberAcc() {
        return numberAcc;
    }
    Double balance() {
        return money;
    }

    void setMoney(Double x) {
        money += x;
    }
}