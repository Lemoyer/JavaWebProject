package com.javaweb.search.service;

import com.javaweb.base.model.PageParams;
import com.javaweb.search.dto.SearchCourseParamDto;
import com.javaweb.search.dto.SearchPageResultDto;
import com.javaweb.search.po.CourseIndex;

/**
 * @description 课程搜索service
 * @author Mr.M
 * @date 2022/9/24 22:40
 * @version 1.0
 */
public interface CourseSearchService {


    /**
     * @description 搜索课程列表
     * @param pageParams 分页参数
     * @param searchCourseParamDto 搜索条件
     * @return com.javaweb.base.model.PageResult<com.javaweb.search.po.CourseIndex> 课程列表
     * @author Mr.M
     * @date 2022/9/24 22:45
    */
    SearchPageResultDto<CourseIndex> queryCoursePubIndex(PageParams pageParams, SearchCourseParamDto searchCourseParamDto);

 }
