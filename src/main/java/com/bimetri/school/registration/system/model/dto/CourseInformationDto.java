package com.bimetri.school.registration.system.model.dto;

import com.bimetri.school.registration.system.model.entity.Student;

import java.util.List;

public interface CourseInformationDto {

    public Long getId();

    String getCourseName();

    List<Student> getStudentList();
}
