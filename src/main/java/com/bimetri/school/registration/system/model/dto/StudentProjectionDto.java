package com.bimetri.school.registration.system.model.dto;

import com.bimetri.school.registration.system.model.entity.Course;

import java.util.List;

/*
*
* Projection interface used to find courses that a specific student is registered in
*
* */
public interface StudentProjectionDto {
    public Long getId();

    public String getName();

    public String getSurname();

    public Long getNumber();

    List<Course> getCourseList();
}
