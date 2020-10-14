package fit5136.bakeshop.entities;

public abstract class User {

    private int employeeId;
    private String employeeName;
    private String email;
    private String password;
    private String TFN;
    private String residentialAddress;
    private int phoneNum;

    public User(int employeeId, String employeeName, String email, String password, String TFN, String residentialAddress, int phoneNum) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;
        this.TFN = TFN;
        this.residentialAddress = residentialAddress;
        this.phoneNum = phoneNum;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTFN() {
        return TFN;
    }

    public void setTFN(String TFN) {
        this.TFN = TFN;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }
}
