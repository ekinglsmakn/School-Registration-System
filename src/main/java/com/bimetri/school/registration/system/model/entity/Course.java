package com.bimetri.school.registration.system.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Course extends BaseEntity {

    @Column(name = "course_name", unique = true)
    private String courseName;

    @JsonIgnore
    @ManyToMany(mappedBy = "courseList", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Student> studentList = new ArrayList<>();

//    @JsonIgnore
//    @ManyToOne
//    private StudentCourse studentCourse;

}
