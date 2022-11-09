package com.bimetri.school.registration.system.service;

import com.bimetri.school.registration.system.model.dto.CourseDto;
import com.bimetri.school.registration.system.model.dto.CourseInformationDto;
import com.bimetri.school.registration.system.model.dto.CourseStudentDto;

import java.util.List;

public interface CourseService {
    CourseDto save(CourseDto courseDto);

    CourseDto update(CourseDto courseDto);

    List<CourseDto> findAll();

    void softDelete(CourseDto courseDto);

    void delete(Long id);

    void addStudent(CourseStudentDto courseStudentDto);

    List<CourseInformationDto> findCourseStudentById(Long courseId);

}
