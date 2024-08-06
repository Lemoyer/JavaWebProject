package com.javaweb.learning.service;

import com.javaweb.base.model.PageResult;
import com.javaweb.learning.model.dto.MyCourseTableParams;
import com.javaweb.learning.model.dto.XcChooseCourseDto;
import com.javaweb.learning.model.dto.XcCourseTablesDto;
import com.javaweb.learning.model.po.XcCourseTables;

public interface MyCourseTablesService {

    public XcChooseCourseDto addChooseCourse(String userId, Long courseId);

    public XcCourseTablesDto getLearningStatus(String userId, Long courseId);

    public boolean saveChooseCourseSuccess(String chooseCourseId);

    public PageResult<XcCourseTables> mycoursetables(MyCourseTableParams params);
}
