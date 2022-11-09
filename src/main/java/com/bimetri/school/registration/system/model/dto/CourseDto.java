package com.bimetri.school.registration.system.model.dto;

import com.bimetri.school.registration.system.model.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private Long id;
    private String courseName;
    private int enable = 1;

}
