package com.zemic.user.model.response;

import com.zemic.common.model.response.BaseResponse;

public class TokenResponse extends BaseResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
