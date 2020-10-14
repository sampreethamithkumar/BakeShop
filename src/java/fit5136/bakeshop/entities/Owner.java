package fit5136.bakeshop.entities;

public class Owner extends User{
    public Owner(int employeeId, String employeeName, String email, String password, String TFN, String residentialAddress, int phoneNum) {
        super(employeeId, employeeName, email, password, TFN, residentialAddress, phoneNum);
    }
}
