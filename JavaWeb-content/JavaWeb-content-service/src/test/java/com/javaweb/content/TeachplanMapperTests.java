package com.javaweb.content;

import com.javaweb.content.mapper.TeachplanMapper;
import com.javaweb.content.model.dto.TeachplanDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeachplanMapperTests {
    @Autowired
    TeachplanMapper teachplanMapper;
    @Test
    public void testSelectTreeMapper() {
        List<TeachplanDto> teachplanList = teachplanMapper.selectTreeNodes(117L);
        System.out.println(teachplanList);
    }
}
