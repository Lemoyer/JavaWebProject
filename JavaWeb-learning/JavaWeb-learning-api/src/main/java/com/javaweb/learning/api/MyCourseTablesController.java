package com.javaweb.learning.api;

import com.javaweb.base.exception.JavaWebException;
import com.javaweb.base.model.PageResult;
import com.javaweb.learning.model.dto.MyCourseTableParams;
import com.javaweb.learning.model.dto.XcChooseCourseDto;
import com.javaweb.learning.model.dto.XcCourseTablesDto;
import com.javaweb.learning.model.po.XcCourseTables;
import com.javaweb.learning.service.MyCourseTablesService;
import com.javaweb.learning.util.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.M
 * @version 1.0
 * @description 我的课程表接口
 * @date 2022/10/25 9:40
 */

@Api(value = "我的课程表接口", tags = "我的课程表接口")
@Slf4j
@RestController
public class MyCourseTablesController {

    @Autowired
    MyCourseTablesService courseTablesService;


    @ApiOperation("添加选课")
    @PostMapping("/choosecourse/{courseId}")
    public XcChooseCourseDto addChooseCourse(@PathVariable("courseId") Long courseId) {
//登录用户
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        if(user == null){
            JavaWebException.cast("请登录后继续选课");
        }
        String userId = user.getId();
        return  courseTablesService.addChooseCourse(userId, courseId);

    }

    @ApiOperation("查询学习资格")
    @PostMapping("/choosecourse/learnstatus/{courseId}")
    public XcCourseTablesDto getLearnstatus(@PathVariable("courseId") Long courseId) {

        SecurityUtil.XcUser user = SecurityUtil.getUser();
        if(user == null){
            JavaWebException.cast("请登录后继续选课");
        }
        String userId = user.getId();
        return  courseTablesService.getLearningStatus(userId, courseId);

    }

    @ApiOperation("我的课程表")
    @GetMapping("/mycoursetable")
    public PageResult<XcCourseTables> mycoursetable(MyCourseTableParams params) {
        SecurityUtil.XcUser user = SecurityUtil.getUser();
        if(user == null){
            JavaWebException.cast("请登录后继续选课");
        }
        String userId = user.getId();
//设置当前的登录用户
        params.setUserId(userId);

        return courseTablesService.mycoursetables(params);
    }

}
