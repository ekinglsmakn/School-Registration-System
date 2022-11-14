package com.bimetri.school.registration.system.controller;

import com.bimetri.school.registration.system.model.dto.StudentCourseDto;
import com.bimetri.school.registration.system.model.dto.StudentDto;
import com.bimetri.school.registration.system.model.dto.StudentProjectionDto;
import com.bimetri.school.registration.system.repository.StudentRepository;
import com.bimetri.school.registration.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/student")
@RestController
@CrossOrigin("http://localhost:3000") //connection with React
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository repository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveStudent(@RequestBody StudentDto studentDto) throws Exception {

        try{
            this.studentService.save(studentDto);
            return new ResponseEntity("Saving Succeeded!", HttpStatus.OK);
        }catch (Exception e){
           return new ResponseEntity("student already exists", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id) {
         studentService.update(studentDto, id);
        return new ResponseEntity("Updated Succeeded!", HttpStatus.OK);
    }

    //Course assignment can only be made via Student.
    @RequestMapping(value = "/addCourse", method = RequestMethod.PUT)
    public ResponseEntity addCourse(@RequestBody StudentCourseDto studentCourseDto) {

        try{
            this.studentService.addCourse(studentCourseDto);
            return new ResponseEntity("Adding Succeeded!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("course already exists", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/softdelete", method = RequestMethod.PUT)
    public ResponseEntity softDeleteStudent(@RequestBody StudentDto studentDto) {
        this.studentService.softDelete(studentDto);
        return new ResponseEntity("Deletion Succeeded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity softDeleteStudent(@PathVariable Long id) {
        this.studentService.delete(id);
        return new ResponseEntity("Deletion Succeeded!", HttpStatus.OK);
    }

    //Lists all students in database
    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public StudentDto findStudentById(@PathVariable Long id) {
        return this.studentService.findById(id);
    }

    //Lists all students in database
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<StudentDto> findAllStudents() {
        return this.studentService.findAll();
    }


    //Filters all courses a particular student is registered in
    @RequestMapping(value = "/registered/{id}", method = RequestMethod.GET)
    public List<StudentProjectionDto> findRegisteredStudentById(@PathVariable Long id) {
        return this.studentService.findRegisteredStudentById(id);
    }

    //Filters all students without registered any courses
    @RequestMapping(value = "/unregistered", method = RequestMethod.GET)
    public List<StudentDto> findUnregisteredStudentById() {
        return this.studentService.findUnregisteredStudent();
    }

}
