package com.javaweb.content.service.impl;


import com.javaweb.content.mapper.CourseCategoryMapper;
import com.javaweb.content.model.dto.CourseCategoryTreeDto;
import com.javaweb.content.service.CourseCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {
    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos = courseCategoryMapper.selectTreeNodes("1");
        //将list转为map以便备用，同时排除root节点
        Map<String,CourseCategoryTreeDto> mapTemp = courseCategoryTreeDtos.stream().filter(item->!id.equals(item.getId())).collect(Collectors.toMap(key->key.getId(),value->value,
                (key1,key2)->key2));
        //最终返回的list
        List<CourseCategoryTreeDto> categoryTreeDtosList= new ArrayList<>();
        //依次便利每个元素，排除根节点
        courseCategoryTreeDtos.stream().filter(item->!id.equals(item.getId())).forEach(
                item->{
                    if(item.getParentid().equals(id)){
                        categoryTreeDtosList.add(item);
                    }
                    CourseCategoryTreeDto courseCategoryTreeDto=mapTemp.get(item.getParentid());
                    if (courseCategoryTreeDto != null){
                        if(courseCategoryTreeDto.getChildrenTreeNodes() == null){
                            courseCategoryTreeDto.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDto>());
                        }
                        courseCategoryTreeDto.getChildrenTreeNodes().add(item);
                    }
                }
        );

        return categoryTreeDtosList;
    }
}
