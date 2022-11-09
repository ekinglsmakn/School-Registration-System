package com.bimetri.school.registration.system.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student extends BaseEntity {
    private String name;
    private String surname;
    @Column(name = "student_number", unique = true)
    private String number; //student number

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST ,fetch = FetchType.EAGER)
    @JoinTable(name = "students_courses", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courseList = new ArrayList<>();
    
}
