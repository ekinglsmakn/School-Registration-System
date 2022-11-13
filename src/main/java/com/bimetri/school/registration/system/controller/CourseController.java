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
    public CourseDto saveCourse(@RequestBody CourseDto courseDto) {
        return this.courseService.save(courseDto);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public CourseDto updateCourse(@RequestBody CourseDto courseDto, @PathVariable Long id) {
        return courseService.update(courseDto, id);
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.PUT)
    public void addCourse(@RequestBody CourseStudentDto courseStudentDto) {
        this.courseService.addStudent(courseStudentDto);
    }

    @RequestMapping(value = "/softdelete", method = RequestMethod.PUT)
    public ResponseEntity softDeleteCourse(@RequestBody CourseDto courseDto) {
        this.courseService.softDelete(courseDto);
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
