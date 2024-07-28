package com.javaweb.search.service;

/**
 * @author Mr.M
 * @version 1.0
 * @description 课程索引service
 * @date 2022/9/24 22:40
 */
public interface IndexService {

    public Boolean addCourseIndex(String indexName,String id,Object object);

    public Boolean updateCourseIndex(String indexName,String id,Object object);

    public Boolean deleteCourseIndex(String indexName,String id);

}
