package com.bimetri.school.registration.system.service;

import com.bimetri.school.registration.system.model.dto.StudentCourseDto;
import com.bimetri.school.registration.system.model.dto.StudentDto;
import com.bimetri.school.registration.system.model.dto.StudentProjectionDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto studentDto);

    StudentDto update(StudentDto studentDto);

    void softDelete(StudentDto studentDto);

    void delete(Long id);

    List<StudentDto> findAll();

    void addCourse(StudentCourseDto studentCourseDto);

    List<StudentProjectionDto> findRegisteredStudentById(Long studentId);

    List<StudentDto> findUnregisteredStudent();


}
