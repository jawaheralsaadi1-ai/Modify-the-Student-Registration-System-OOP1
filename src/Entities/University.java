package Entities;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public List<Student> getStudents() { return students; }
    public List<Teacher> getTeachers() { return teachers; }
    public List<Department> getDepartments() { return departments; }
    public List<Course> getCourses() { return courses; }
}