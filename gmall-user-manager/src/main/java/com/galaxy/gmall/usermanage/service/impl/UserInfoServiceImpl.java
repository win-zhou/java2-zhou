package com.galaxy.gmall.usermanage.service.impl;

import com.galaxy.gmall.usermanage.bean.UserInfo;
import com.galaxy.gmall.usermanage.mapper.UserInfoMapper;
import com.galaxy.gmall.usermanage.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by asus on 2020/11/18
 */
@Service
@Transactional
public class UserInfoServiceImpl implements IUserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> getUserInfoListAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",name);
        userInfoMapper.updateByExampleSelective(userInfo,example);
    }

    @Override
    public void delUser(UserInfo userInfo) {
        userInfoMapper.deleteByPrimaryKey(userInfo.getId());
    }
}
