package Entities;

import Entities.ParentEntity;

public class Student extends ParentEntity {
    private String name;

    public Student(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}