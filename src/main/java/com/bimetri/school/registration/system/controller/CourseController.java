package com.bimetri.school.registration.system.controller;

import com.bimetri.school.registration.system.model.dto.*;
import com.bimetri.school.registration.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/course")
@RestController
@CrossOrigin("http://localhost:3000") //connection with React
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity saveCourse(@RequestBody CourseDto courseDto) {
        try {
            this.courseService.save(courseDto);
            return new ResponseEntity("Saving Succeeded!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("course already exists", HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateCourse(@RequestBody CourseDto courseDto, @PathVariable Long id) {
        courseService.update(courseDto, id);
        return new ResponseEntity("updated Succeeded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.PUT)
    public ResponseEntity addCourse(@RequestBody CourseStudentDto courseStudentDto) {
        this.courseService.addStudent(courseStudentDto);
        return new ResponseEntity("Added Succeeded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/softdelete/{id}", method = RequestMethod.PUT)
    public ResponseEntity softDeleteCourse(@PathVariable Long id) {
        this.courseService.softDelete(id);
        return new ResponseEntity("Deleted Succeeded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCourse(@PathVariable Long id) {
        this.courseService.delete(id);
        return new ResponseEntity("Deleted Succeeded!", HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<CourseDto> findAllCourses() {
        return this.courseService.findAll();
    }


    //lists all students registered in a specific course (by course id)
    @RequestMapping(value = "/filterByCourse", method = RequestMethod.GET)
    public List<CourseProjectionDto> filterByCourse(@RequestParam("id") Long id) {
        return this.courseService.filterByCourse(id);
    }
}
