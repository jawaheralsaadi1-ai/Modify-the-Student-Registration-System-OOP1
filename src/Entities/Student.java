package Entities;

/**
 * STUDENT ENTITY
 * Inherits id, name, email, and phone from ParentEntity.
 */
public class Student extends ParentEntity {
    // You can add student-specific fields here later, like 'GPA' or 'Major'
    public Student() {
        super(); // Calls the ParentEntity constructor to setup the ID
    }
}