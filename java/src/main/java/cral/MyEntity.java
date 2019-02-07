package cral;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@javax.persistence.Entity
public class MyEntity {

    @Id
    private Long id;
    private String test;
    @Column
    @Enumerated(EnumType.STRING)
    private Main.MyEnum myEnum;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Main.MyEnum getMyEnum() {
        return myEnum;
    }

    public void setMyEnum(Main.MyEnum myEnum) {
        this.myEnum = myEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyEntity{" +
                "id=" + id +
                ", test='" + test + '\'' +
                ", myEnum=" + myEnum +
                '}';
    }
}