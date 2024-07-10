package com.javaweb.content.service;

import com.javaweb.content.model.dto.SaveTeachplanDto;
import com.javaweb.content.model.dto.TeachplanDto;

import java.util.List;

public interface TeachplanService {
    public List<TeachplanDto> findTeachplanTree(Long courseId);
    public void saveTeachplan(SaveTeachplanDto teachplanDto);
}
