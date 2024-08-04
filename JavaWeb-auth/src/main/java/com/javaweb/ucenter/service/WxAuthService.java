package com.javaweb.ucenter.service;

import com.javaweb.ucenter.model.po.XcUser;

public interface WxAuthService {
    public XcUser wxAuth(String code);

}
