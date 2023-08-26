package com.spring.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity

public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "course_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "course_name",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String courseName;
    @Column(
            name = "department",
            columnDefinition = "TEXT",
            nullable = false
    )
    private String department;

    @ManyToMany(
            mappedBy = "courses"
    )
    private List<Student> students = new ArrayList<>();

    public Course() {
    }

    public Course(String courseName, String department) {
        this.courseName = courseName;
        this.department = department;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
