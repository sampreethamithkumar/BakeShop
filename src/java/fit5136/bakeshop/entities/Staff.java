package fit5136.bakeshop.entities;

public class Staff extends User{
    private int storeId;

    public Staff(int employeeId, String employeeName, String email, String password, String TFN, String residentialAddress, int phoneNum, int storeId) {
        super(employeeId, employeeName, email, password, TFN, residentialAddress, phoneNum);
        this.storeId = storeId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }
}
