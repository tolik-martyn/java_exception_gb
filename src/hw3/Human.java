package hw3;

public class Human {
    private String lastName;
    private String firstName;
    private String middleName;
    private String dateOfBirth;
    private long phoneNumber;
    private char gender;

    public Human(String lastName, String firstName, String middleName, String dateOfBirth, long phoneNumber,
            char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "<" + lastName + "><" + firstName + "><" + middleName + "><" + dateOfBirth + "><" + phoneNumber + "><"
                + gender + ">";
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
