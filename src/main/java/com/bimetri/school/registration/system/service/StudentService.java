package com.bimetri.school.registration.system.service;

import com.bimetri.school.registration.system.model.dto.StudentCourseDto;
import com.bimetri.school.registration.system.model.dto.StudentDto;
import com.bimetri.school.registration.system.model.dto.StudentProjectionDto;

import java.util.List;

public interface StudentService {
    String save(StudentDto studentDto);

    StudentDto update(StudentDto studentDto, Long id);

    void softDelete(StudentDto studentDto);

    void delete(Long id);

    StudentDto findById(Long id);

    List<StudentDto> findAll();

    void addCourse(StudentCourseDto studentCourseDto);

    List<StudentProjectionDto> findRegisteredStudentById(Long id);

    List<StudentDto> findUnregisteredStudent();


}
