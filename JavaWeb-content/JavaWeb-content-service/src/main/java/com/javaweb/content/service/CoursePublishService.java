package com.javaweb.content.service;

import com.javaweb.content.model.dto.CoursePreviewDto;

public interface CoursePublishService {

    public CoursePreviewDto getCoursePreviewInfo(Long courseId);
}
