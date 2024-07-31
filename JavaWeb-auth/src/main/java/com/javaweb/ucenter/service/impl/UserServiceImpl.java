package com.javaweb.ucenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.javaweb.ucenter.mapper.XcUserMapper;
import com.javaweb.ucenter.model.dto.AuthParamsDto;
import com.javaweb.ucenter.model.dto.XcUserExt;
import com.javaweb.ucenter.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    XcUserMapper xcUserMapper;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    AuthService authService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthParamsDto authParamsDto = null;
        try {
            //将认证参数转为AuthParamsDto类型
            authParamsDto = JSON.parseObject(s, AuthParamsDto.class);
        } catch (Exception e) {
            log.info("认证请求不符合项目要求:{}",s);
            throw new RuntimeException("认证请求数据格式不对");
        }
//        //开始认证
//        authService.execute(authParamsDto);
//        //账号
//        String username = authParamsDto.getUsername();
//        XcUser user = xcUserMapper.selectOne(new LambdaQueryWrapper<XcUser>().eq(XcUser::getUsername, username));
//        if(user==null){
//            //返回空表示用户不存在
//            return null;
//        }
//        //取出数据库存储的正确密码
//        String password  =user.getPassword();
//        //用户权限,如果不加报Cannot pass a null GrantedAuthority collection
//        String[] authorities = {"p1"};
//        //将user对象转json
//        String userString = JSON.toJSONString(user);
//        //创建UserDetails对象
//        UserDetails userDetails = User.withUsername(userString).password(password).authorities(authorities).build();
//
//        return userDetails;
        //认证方法
        String authType = authParamsDto.getAuthType();
        AuthService authService =  applicationContext.getBean(authType + "_authservice",AuthService.class);
        XcUserExt user = authService.execute(authParamsDto);

        return getUserPrincipal(user);
    }

    public UserDetails getUserPrincipal(XcUserExt user){
        //用户权限,如果不加报Cannot pass a null GrantedAuthority collection
        String[] authorities = {"p1"};
        String password = user.getPassword();
        //为了安全在令牌中不放密码
        user.setPassword(null);
        //将user对象转json
        String userString = JSON.toJSONString(user);
        //创建UserDetails对象
        UserDetails userDetails = User.withUsername(userString).password(password ).authorities(authorities).build();
        return userDetails;
    }
}
