package com.bimetri.school.registration.system.controller;

import com.bimetri.school.registration.system.model.dto.StudentCourseDto;
import com.bimetri.school.registration.system.model.dto.StudentDto;
import com.bimetri.school.registration.system.model.dto.StudentInformationDto;
import com.bimetri.school.registration.system.model.entity.Student;
import com.bimetri.school.registration.system.repository.StudentRepository;
import com.bimetri.school.registration.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository repository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public StudentDto saveStudent(@RequestBody StudentDto studentDto) {
        return this.studentService.save(studentDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public StudentDto updateStudent(@RequestBody StudentDto studentDto) {
        return studentService.update(studentDto);
    }

    //Course assignment can only be made via Student.
    @RequestMapping(value = "/addCourse", method = RequestMethod.PUT)
    public void addCourse(@RequestBody StudentCourseDto studentCourseDto) {
        this.studentService.addCourse(studentCourseDto);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudent(@PathVariable("id") Long id) {
        this.studentService.deleteById(id);
        return new ResponseEntity("Deleting Succeeded!",HttpStatus.OK);
    }

    //Lists all students in database
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<StudentDto> findAllStudents() {
        return this.studentService.findAll();
    }


    //Filters all courses a particular student is registered in
    @RequestMapping(value = "/registered", method = RequestMethod.GET)
    public List<StudentInformationDto> findRegisteredStudentById(@RequestParam("id") Long id) {
        return this.studentService.findRegisteredStudentById(id);
    }

    //Filters all students without registered any courses
    @RequestMapping(value = "/unregistered", method = RequestMethod.GET)
    public List<StudentDto> findUnregisteredStudentById() {
        return this.studentService.findUnregisteredStudent();
    }

}
