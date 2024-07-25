package com.javaweb.media.service;

import com.javaweb.base.model.PageParams;
import com.javaweb.base.model.PageResult;
import com.javaweb.base.model.RestResponse;
import com.javaweb.media.model.dto.QueryMediaParamsDto;
import com.javaweb.media.model.dto.UploadFileParamsDto;
import com.javaweb.media.model.dto.UploadFileResultDto;
import com.javaweb.media.model.po.MediaFiles;

import java.io.File;

/**
 * @description 媒资文件管理业务类
 * @author Mr.M
 * @date 2022/9/10 8:55
 * @version 1.0
 */
public interface MediaFileService {

 /**
  * @description 媒资文件查询方法
  * @param pageParams 分页参数
  * @param queryMediaParamsDto 查询条件
  * @return com.javaweb.base.model.PageResult<po.model.com.javaweb.media.MediaFiles>
  * @author Mr.M
  * @date 2022/9/10 8:57
 */
 public PageResult<MediaFiles> queryMediaFiels(Long companyId,PageParams pageParams, QueryMediaParamsDto queryMediaParamsDto);

 public UploadFileResultDto uploadFile(Long companyId, UploadFileParamsDto uploadFileParamsDto, String localFilePath);

 public MediaFiles addMediaFilesToDb(Long companyId,String fileMd5,UploadFileParamsDto uploadFileParamsDto,String bucket,String objectName);

 public RestResponse<Boolean> checkFile(String fileMd5);

 public RestResponse<Boolean> checkChunk(String fileMd5, int chunkIndex);

 public RestResponse uploadChunk(String fileMd5,int chunk,String localChunkFilePath);

 public RestResponse mergechunks(Long companyId,String fileMd5,int chunkTotal,UploadFileParamsDto uploadFileParamsDto);

 public File downloadFileFromMinIO(String bucket, String objectName);

 public boolean addMediaFilesToMinIO(String localFilePath,String mimeType,String bucket, String objectName);

 public String getFilePathByMd5(String fileMd5, String extension);
}
