package com.bimetri.school.registration.system.controller;

import com.bimetri.school.registration.system.model.dto.*;
import com.bimetri.school.registration.system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/course")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public CourseDto saveCourse(@RequestBody CourseDto courseDto) {
        return this.courseService.save(courseDto);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public CourseDto updateCourse(@RequestBody CourseDto courseDto) {
        return courseService.update(courseDto);
    }

//    @RequestMapping(value = "/addStudent", method = RequestMethod.PUT)
//    public void addCourse(@RequestBody CourseStudentDto courseStudentDto) {
//        this.courseService.addStudent(courseStudentDto);
//    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteCourse(@RequestBody CourseDto courseDto) {
        this.courseService.deleteById(courseDto);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<CourseDto> findAllCourses() {
        return this.courseService.findAll();
    }


    //Filters all students with a specific course (courseId)
    @RequestMapping(value = "/filterByCourseId", method = RequestMethod.GET)
    public List<CourseInformationDto> findCourseById(@RequestParam("id") Long id){
        return this.courseService.findCourseStudentById(id);
    }
}
