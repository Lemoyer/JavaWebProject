package com.javaweb.ucenter.service;

import com.javaweb.ucenter.model.dto.AuthParamsDto;
import com.javaweb.ucenter.model.dto.XcUserExt;

public interface AuthService {

    XcUserExt execute(AuthParamsDto authParamsDto);

}
