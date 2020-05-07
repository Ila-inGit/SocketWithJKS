package org.example.obj;


import org.example.VisitorClient;
import org.example.VisitorServer;

public class ObjPerson extends ObjInNetwork{

    private String name;
    private int age;

    public ObjPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public void accept(VisitorServer visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(VisitorClient visitorClient) {
        visitorClient.visit(this);
    }


}
