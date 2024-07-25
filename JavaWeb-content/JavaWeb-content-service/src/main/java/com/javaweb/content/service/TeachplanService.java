package com.javaweb.content.service;

import com.javaweb.content.model.dto.BindTeachplanMediaDto;
import com.javaweb.content.model.dto.SaveTeachplanDto;
import com.javaweb.content.model.dto.TeachplanDto;
import com.javaweb.content.model.po.TeachplanMedia;

import java.util.List;

public interface TeachplanService {
    public List<TeachplanDto> findTeachplanTree(Long courseId);
    public void saveTeachplan(SaveTeachplanDto teachplanDto);
    public TeachplanMedia associationMedia(BindTeachplanMediaDto bindTeachplanMediaDto);
    public void unassociationMedia(Long teachPlanId, String mediaId);

}
