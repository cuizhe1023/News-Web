package com.zemic.user.service;

import com.zemic.common.result.Code;
import com.zemic.common.result.SingleResult;
import com.zemic.common.service.BaseService;
import com.zemic.user.mapper.UserMapper;
import com.zemic.user.model.bean.UserBean;
import com.zemic.user.model.request.LoginRequest;
import com.zemic.user.model.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserService extends BaseService {

    @Autowired
    private UserMapper userMapper;

    public SingleResult<TokenResponse> login(LoginRequest request){
        List<UserBean> userList = userMapper.selectUser(request.getMobile(),request.getPassword());
        if (null!=userList && userList.size() >0){
            String token = getToken(request.getMobile(),request.getPassword());
            TokenResponse response = new TokenResponse();
            response.setToken(token);
            return SingleResult.buildSuccess(response);
        }else {
            return SingleResult.buildFailure(Code.ERROR,"手机号或密码输入不正确！");
        }
    }

}
