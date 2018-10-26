package cral;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@javax.persistence.Entity
public class MyEntity {

    @Id
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}