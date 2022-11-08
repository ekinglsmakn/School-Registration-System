package com.bimetri.school.registration.system.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
/*
 * This Dto class is used to assign courses to a student
 *
 * */
@Getter
@Setter
public class StudentCourseDto {
    private Long student_id;
    private List<Long> course_id_List;
}
