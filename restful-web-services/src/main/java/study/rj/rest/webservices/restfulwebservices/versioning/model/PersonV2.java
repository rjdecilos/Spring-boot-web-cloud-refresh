package study.rj.rest.webservices.restfulwebservices.versioning.model;

public class PersonV2 {
    private String lastName;
    private String firstName;

    public PersonV2() {}

    public PersonV2(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
