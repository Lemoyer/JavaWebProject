package com.javaweb.content;

import com.javaweb.content.mapper.CourseCategoryMapper;
import com.javaweb.content.model.dto.CourseCategoryTreeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseCategoryMapperTests {
    @Autowired
    CourseCategoryMapper courseCategoryMapper;
    @Test
    public void testCourseCategoryMapper() {
        List<CourseCategoryTreeDto> courseBasePageResult = courseCategoryMapper.selectTreeNodes("1");
        System.out.println(courseBasePageResult);
    }
}



