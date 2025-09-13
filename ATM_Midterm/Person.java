public class Person {
    private String nationalId;
    private String fullName;
    private String gender;

    public Person(String nationalId, String fullName, String gender) {
        this.nationalId = nationalId;
        this.fullName = fullName;
        this.gender = gender;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getGender() {
        return gender;
    }
}
