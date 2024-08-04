package com.javaweb.content.service;

import com.javaweb.content.model.dto.CoursePreviewDto;
import com.javaweb.content.model.po.CoursePublish;

import java.io.File;

public interface CoursePublishService {

    public CoursePreviewDto getCoursePreviewInfo(Long courseId);

    public void commitAudit(Long companyId,Long courseId);

    public void publish(Long companyId,Long courseId);

    public File generateCourseHtml(Long courseId);

    public void  uploadCourseHtml(Long courseId,File file);

    public Boolean saveCourseIndex(Long courseId);

    public CoursePublish getCoursePublish(Long courseId);
}
