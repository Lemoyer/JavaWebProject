package com.javaweb.content.service;

import com.javaweb.content.model.dto.CourseCategoryTreeDto;

import java.util.List;

public interface CourseCategoryService {
    List<CourseCategoryTreeDto> queryTreeNodes(String id);
}
