package com.javaweb.content;

import com.javaweb.content.model.dto.CourseCategoryTreeDto;
import com.javaweb.content.service.CourseCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class CourseCategoryServiceTests {
    @Autowired
    CourseCategoryService courseCategoryService;
    @Test
    void testCourseCategoryService(){
        List<CourseCategoryTreeDto> result = courseCategoryService.queryTreeNodes("1");
        System.out.println(result);
    }

}
