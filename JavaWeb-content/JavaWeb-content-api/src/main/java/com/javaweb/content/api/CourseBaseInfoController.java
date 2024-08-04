package com.javaweb.content.api;

import com.javaweb.base.exception.ValidationGroups;
import com.javaweb.base.model.PageParams;
import com.javaweb.base.model.PageResult;
import com.javaweb.content.model.dto.AddCourseDto;
import com.javaweb.content.model.dto.CourseBaseInfoDto;
import com.javaweb.content.model.dto.EditCourseDto;
import com.javaweb.content.model.dto.QueryCourseParamsDto;
import com.javaweb.content.model.po.CourseBase;
import com.javaweb.content.service.CourseBaseInfoService;
import com.javaweb.content.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "课程信息编辑接口",tags = "课程信息编辑接口")
@RestController
public class CourseBaseInfoController {
    @Autowired
    CourseBaseInfoService courseBaseInfoService;
    @ApiOperation("课程查询接口")
    @PreAuthorize("hasAuthority('xc_teachmanager_course_list')")
    @PostMapping("/course/list")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParams){
        //取出用户身份
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        //机构id
        Long companyId = null;
        if (StringUtils.isNotEmpty(user.getCompanyId())){
            companyId = Long.parseLong(user.getCompanyId());
        }

        PageResult<CourseBase> result = courseBaseInfoService.queryCourseBaseList(companyId,pageParams, queryCourseParams);
        return result;
    }
    @ApiOperation("课程创建接口")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(@RequestBody @Validated({ValidationGroups.Insert.class})  AddCourseDto addCourseDto){
        Long companyId = 1232141425L;
        CourseBaseInfoDto courseDto = courseBaseInfoService.createCourseBase(companyId,addCourseDto);
        return courseDto;
    }

    @ApiOperation("根据课程id查询课程基础信息")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseById(@PathVariable Long courseId){
        //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        System.out.println(user.getName());
        return courseBaseInfoService.getCourseBaseInfo(courseId);
    }

    @ApiOperation("课程更新接口")
    @PutMapping("/course")
    public CourseBaseInfoDto modifyCourseBase(@RequestBody @Validated({ValidationGroups.Update.class}) EditCourseDto editCourseDto){
        Long companyId = 1232141425L;
        return courseBaseInfoService.updateCourseBase(companyId,editCourseDto);
    }


}
