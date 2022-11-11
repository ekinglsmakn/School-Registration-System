package com.bimetri.school.registration.system.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
 * This Dto class is used to add course data to student
 *
 * */
@Getter
@Setter
public class StudentCourseDto {
    private Long student_id;
    private List<Long> course_id_List;
}
