package com.bimetri.school.registration.system.serviceImp;

import com.bimetri.school.registration.system.config.CustomizedMapper;
import com.bimetri.school.registration.system.model.dto.*;
import com.bimetri.school.registration.system.model.entity.Course;
import com.bimetri.school.registration.system.model.entity.Student;
import com.bimetri.school.registration.system.repository.CourseRepository;
import com.bimetri.school.registration.system.repository.StudentRepository;
import com.bimetri.school.registration.system.service.CourseService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CustomizedMapper mapper;

    @Autowired
    private StudentRepository studentRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String save(CourseDto courseDto) {
        if (courseRepository.findById(courseDto.getId()).isPresent()) {
            return "course already exists";
        } else {
            Course course = mapper.map(courseDto, Course.class);
            this.courseRepository.save(course);
            return "saving succeded";
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CourseDto update(CourseDto courseDto, Long id) {
        //parameter "courseDto" contains new information
        Course course = this.courseRepository.findById(id).orElse(null);
        course.setCourseName(courseDto.getCourseName());
        course.setEnable(courseDto.getEnable());
        this.courseRepository.save(course);
        return mapper.map(course, CourseDto.class);
    }

    @Transactional(readOnly = true)
    @Override
    public List<CourseDto> findAll() {
        return mapper.map(this.courseRepository.findAll(), new TypeToken<List<CourseDto>>() {
        }.getType());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {

        this.courseRepository.deleteById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void softDelete(Long id) {
        Course course = this.courseRepository.findById(id).orElse(null);

        if (course.getEnable() == 1) {
            course.setEnable(0);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addStudent(CourseStudentDto courseStudentDto) {
        Course course = mapper.map(
                this.courseRepository.findById(courseStudentDto.getCourse_id()).get(), Course.class);

        for (Long id : courseStudentDto.getStudent_id_list()) {

            //A Course Cannot Register More Than 50 Students
            if (courseStudentDto.getStudent_id_list().size() < 50) {
                Student student = this.studentRepository.findById(id).orElse(null);
                course.getStudentList().add(student);
            }
        }
    }


    //finds students registered in a specific course
    @Transactional(readOnly = true)
    @Override
    public List<CourseProjectionDto> filterByCourse(Long courseId) {
        return mapper.map(this.courseRepository.findAllById(courseId), new TypeToken<List<CourseProjectionDto>>() {
        }.getType());
    }


}
