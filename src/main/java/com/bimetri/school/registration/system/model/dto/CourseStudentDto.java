package com.bimetri.school.registration.system.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
* This Dto class is used to assign students to a course
*
* */
@Getter
@Setter
public class CourseStudentDto {
    private Long course_id;
    private List<Long> student_id_list;
}
