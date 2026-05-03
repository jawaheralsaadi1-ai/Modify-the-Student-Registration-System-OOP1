package Entities;

import java.util.ArrayList;
import java.util.List;

public class University {
    // These lists act like our database tables
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    // We need these 'get' methods so the Services can find the lists
    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Department> getDepartments() { return departments; }
    public List<Course> getCourses() { return courses; }
}