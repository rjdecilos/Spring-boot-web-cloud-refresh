package study.rj.rest.webservices.restfulwebservices.filtering.model;

// Static filtering JsonIgnore, JsonIgnoreProperties
// Dynamic filtering JsonFilter

//@JsonIgnoreProperties(value={"field1", "field2"})

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter")
public class SomeBean {
    private String field1;
    private String field2;
//    @JsonIgnore - better approach
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getField2() {
        return field2;
    }

    public String getField3() {
        return field3;
    }
}
