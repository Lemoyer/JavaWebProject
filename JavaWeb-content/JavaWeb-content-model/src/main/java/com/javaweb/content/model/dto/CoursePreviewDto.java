package com.javaweb.content.model.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class CoursePreviewDto {
    CourseBaseInfoDto courseBase;
    List<TeachplanDto> teachplans;
}
