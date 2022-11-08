package com.bimetri.school.registration.system.model.dto;

import com.bimetri.school.registration.system.model.entity.Course;

import java.util.List;

public interface StudentInformationDto {
    public String getName();
    public String getSurname();
    List<Course> getCourseList();
}
