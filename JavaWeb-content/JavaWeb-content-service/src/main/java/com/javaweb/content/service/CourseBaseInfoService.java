package com.javaweb.content.service;

import com.javaweb.base.model.PageParams;
import com.javaweb.base.model.PageResult;
import com.javaweb.content.model.dto.AddCourseDto;
import com.javaweb.content.model.dto.CourseBaseInfoDto;
import com.javaweb.content.model.dto.QueryCourseParamsDto;
import com.javaweb.content.model.po.CourseBase;
/**
 * 课程基本信息管理业务接口
**/
public interface CourseBaseInfoService  {
    PageResult<CourseBase> queryCourseBaseList(PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

    CourseBaseInfoDto createCourseBase(Long compayId, AddCourseDto addCourseDto);
 }
