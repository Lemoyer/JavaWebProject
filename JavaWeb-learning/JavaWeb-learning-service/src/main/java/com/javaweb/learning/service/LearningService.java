package com.javaweb.learning.service;

import com.javaweb.base.model.RestResponse;

public interface LearningService {

    public RestResponse<String> getVideo(String userId, Long courseId, Long teachplanId, String mediaId);
}
