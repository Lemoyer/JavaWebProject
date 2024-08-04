package com.javaweb.learning.service;

import com.javaweb.learning.model.dto.XcChooseCourseDto;
import com.javaweb.learning.model.dto.XcCourseTablesDto;

public interface MyCourseTablesService {

    public XcChooseCourseDto addChooseCourse(String userId, Long courseId);

    public XcCourseTablesDto getLearningStatus(String userId, Long courseId);

}
