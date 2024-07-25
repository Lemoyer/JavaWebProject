package com.javaweb.content.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
@ApiModel(value = "BindTeachplanMediaDto", description = "媒资绑定Dto")
public class BindTeachplanMediaDto {
    @ApiModelProperty(value = "媒资id", required = true)
    private String mediaId;

    @ApiModelProperty(value = "媒资名称", required = true)
    private String fileName;

    @ApiModelProperty(value = "课程计划标识", required = true)
    private Long teachplanId;
}
