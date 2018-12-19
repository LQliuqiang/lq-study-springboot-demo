package lq.study.springboot.demo.mapper;

import lq.study.springboot.demo.bean.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {

    UserInfo getUserInfoById(@Param("id") Integer id);

    boolean addUserInfo(UserInfo userInfo);

}
