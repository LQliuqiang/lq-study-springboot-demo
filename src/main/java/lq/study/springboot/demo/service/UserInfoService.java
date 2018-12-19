package lq.study.springboot.demo.service;

import lq.study.springboot.demo.bean.UserInfo;
import lq.study.springboot.demo.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


   public UserInfo getUserInfoById(Integer id){
       return userInfoMapper.getUserInfoById(id);
   }

   public boolean addUserInfo(UserInfo userInfo){
       return userInfoMapper.addUserInfo(userInfo);
   }

}
