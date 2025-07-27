public class Manager extends Person {
    private String loginId;
    private String password;

    public Manager(String nationalId, String fullName, String gender, String loginId, String password) {
        super(nationalId, fullName, gender);
        this.loginId = loginId;
        this.password = password;
    }

    public String getLoginId() {
        return loginId;
    }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }
}
