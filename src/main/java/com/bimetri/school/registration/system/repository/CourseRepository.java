package com.bimetri.school.registration.system.repository;

import com.bimetri.school.registration.system.model.dto.CourseProjectionDto;
import com.bimetri.school.registration.system.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<CourseProjectionDto> findAllById(@Param("id") Long courseId);
}
