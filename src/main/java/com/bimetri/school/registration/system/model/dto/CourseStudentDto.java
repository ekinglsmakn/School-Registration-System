package com.bimetri.school.registration.system.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/*
 * This Dto class is used to add student data to course
 *
 * */
@Getter
@Setter
public class CourseStudentDto {
    private Long course_id;
    private List<Long> student_id_list;
}
