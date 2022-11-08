package com.bimetri.school.registration.system.service;

import com.bimetri.school.registration.system.model.dto.StudentCourseDto;
import com.bimetri.school.registration.system.model.dto.StudentDto;
import com.bimetri.school.registration.system.model.dto.StudentInformationDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto studentDto);

    StudentDto update(StudentDto studentDto);

    void deleteById(Long id);

    List<StudentDto> findAll();

    void addCourse(StudentCourseDto studentCourseDto);

    List<StudentInformationDto> findRegisteredStudentById(Long studentId);

    List<StudentDto> findUnregisteredStudent();


}
