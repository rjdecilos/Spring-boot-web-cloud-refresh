package study.rj.rest.webservices.restfulwebservices.versioning.model;

public class PersonV1 {
    private String name;

    public PersonV1() {

    }

    public PersonV1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
