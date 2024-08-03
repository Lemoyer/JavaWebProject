package com.javaweb.ucenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.javaweb.ucenter.mapper.XcUserMapper;
import com.javaweb.ucenter.model.dto.AuthParamsDto;
import com.javaweb.ucenter.model.dto.XcUserExt;
import com.javaweb.ucenter.model.po.XcUser;
import com.javaweb.ucenter.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service("wx_authservice")
public class WxAuthServiceImpl implements AuthService {

    @Autowired
    XcUserMapper xcUserMapper;

//    public XcUser wxAuth(String code) {
//        //TODO: 获取access_token
//
//        //TODO: 获取用户信息
//
//        // 这里先用个假数据
//        XcUser xcUser = xcUserMapper.selectOne(new LambdaQueryWrapper<XcUser>().eq(XcUser::getUsername, "Kyle"));
//        //TODO: 添加用户信息到数据库
//
//        return xcUser;
//    }

    @Override
    public XcUserExt execute(AuthParamsDto authParamsDto) {

        //账号
        String username = authParamsDto.getUsername();
        XcUser user = xcUserMapper.selectOne(new LambdaQueryWrapper<XcUser>().eq(XcUser::getUsername, username));
        if(user==null){
            //返回空表示用户不存在
            throw new RuntimeException("账号不存在");
        }
        XcUserExt xcUserExt = new XcUserExt();
        BeanUtils.copyProperties(user,xcUserExt);
        return xcUserExt;
    }
}
