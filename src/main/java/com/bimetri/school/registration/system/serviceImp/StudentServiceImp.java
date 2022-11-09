package com.bimetri.school.registration.system.serviceImp;

import com.bimetri.school.registration.system.config.CustomizedMapper;
import com.bimetri.school.registration.system.model.dto.StudentCourseDto;
import com.bimetri.school.registration.system.model.dto.StudentDto;
import com.bimetri.school.registration.system.model.dto.StudentInformationDto;
import com.bimetri.school.registration.system.model.entity.Course;
import com.bimetri.school.registration.system.model.entity.Student;
import com.bimetri.school.registration.system.repository.CourseRepository;
import com.bimetri.school.registration.system.repository.StudentRepository;
import com.bimetri.school.registration.system.service.StudentService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CustomizedMapper mapper;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public StudentDto save(StudentDto studentDto) {

        Student student = mapper.map(studentDto, Student.class);
        this.studentRepository.save(student);
        return mapper.map(student, StudentDto.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public StudentDto update(StudentDto studentDto) {
        Optional<Student> studentOptional = this.studentRepository.findById(studentDto.getId());
        Student student = new Student();
        if (studentOptional.isPresent()) {
            student = studentOptional.get();
            student.setName(studentDto.getName());
            student.setSurname(studentDto.getSurname());
            student.setNumber(studentDto.getNumber());
            this.studentRepository.save(student);
        }
        return mapper.map(student, StudentDto.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void softDelete(StudentDto studentDto) {
        Student student = this.studentRepository.findById(studentDto.getId()).orElse(null);
        if (student.getEnable() == 1) {
            student.setEnable(0);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        this.studentRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentDto> findAll() {
        return mapper.map(this.studentRepository.findAll(), new TypeToken<List<StudentDto>>() {
        }.getType());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addCourse(StudentCourseDto studentCourseDto) {

        Student student = mapper.map(
                this.studentRepository.findById(studentCourseDto.getStudent_id()).get(), Student.class);

        for (Long id : studentCourseDto.getCourse_id_List()) {
            //A student cannot be registered in more than 5 courses.
            if (studentCourseDto.getCourse_id_List().size() < 5) {
                Course course = this.courseRepository.findById(id).orElse(null);
                student.getCourseList().add(course);
            }
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentInformationDto> findRegisteredStudentById(Long studentId) {
        return mapper.map(this.studentRepository.findAllById(studentId), new TypeToken<List<StudentInformationDto>>() {
        }.getType());
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentDto> findUnregisteredStudent() {
        return mapper.map(this.studentRepository.findStudentByCourseList_Empty(), new TypeToken<List<StudentDto>>() {
        }.getType());
    }

}
