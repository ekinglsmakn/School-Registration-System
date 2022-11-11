package com.bimetri.school.registration.system.model.dto;

import com.bimetri.school.registration.system.model.entity.Student;

import java.util.List;
/*
* Projection interface used to find students registered in a specific course
*
* */
public interface CourseProjectionDto {

    public Long getId();

    String getCourseName();

    List<Student> getStudentList();
}
