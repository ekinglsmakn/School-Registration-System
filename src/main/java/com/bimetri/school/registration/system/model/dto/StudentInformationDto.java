package com.bimetri.school.registration.system.model.dto;

import com.bimetri.school.registration.system.model.entity.Course;

import java.util.List;

public interface StudentInformationDto {
    public Long getId();

    public String getName();

    public String getSurname();

    public Long getNumber();

    List<Course> getCourseList();
}
