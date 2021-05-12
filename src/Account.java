public class Account {

    private String FirstName;
    private String LastName;
    private AccInfo selfAccInfo;

    Account(String userFirstName, String userLastName) {
        FirstName = userFirstName;
        LastName = userLastName;
        selfAccInfo = new AccInfo();
    }

    String getName() {
        return (FirstName + " " + LastName);
    }
    int getNumberAcc() {
        return selfAccInfo.get_numberAcc();
    }
    Double balanceAcc() {
        return selfAccInfo.balance();
    }
    void setAccBalance(Double x) {
        selfAccInfo.setMoney(x);
    }

}






