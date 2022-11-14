package com.bimetri.school.registration.system.repository;

import com.bimetri.school.registration.system.model.dto.StudentProjectionDto;
import com.bimetri.school.registration.system.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //Lists students registered in at least one course
    List<StudentProjectionDto> findAllById(@Param("id") Long studentId);

    //lists students who have not registered for any course from the database
    List<Student> findStudentByCourseList_Empty();

    Student findByName(String name);


}
