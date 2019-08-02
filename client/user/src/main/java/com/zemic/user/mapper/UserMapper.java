package com.zemic.user.mapper;

import com.zemic.user.model.bean.UserBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select id,mobile,password from news_user where mobile = #{mobile} and password = #{password}")
    List<UserBean> selectUser(String mobile, String password);

}
