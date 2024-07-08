package com.javaweb.content.api;

import com.javaweb.base.model.PageParams;
import com.javaweb.base.model.PageResult;
import com.javaweb.content.model.dto.AddCourseDto;
import com.javaweb.content.model.dto.CourseBaseInfoDto;
import com.javaweb.content.model.dto.QueryCourseParamsDto;
import com.javaweb.content.model.po.CourseBase;
import com.javaweb.content.service.CourseBaseInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "课程信息编辑接口",tags = "课程信息编辑接口")
@RestController
public class CourseBaseInfoController {
    @Autowired
    CourseBaseInfoService courseBaseInfoService;
    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParams){
        PageResult<CourseBase> result = courseBaseInfoService.queryCourseBaseList(pageParams, queryCourseParams);
        return result;

    }

    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody @Validated  AddCourseDto addCourseDto){
        Long companyId = 1232141425L;
        CourseBaseInfoDto courseDto = courseBaseInfoService.createCourseBase(companyId,addCourseDto);
        return courseDto;

    }}
