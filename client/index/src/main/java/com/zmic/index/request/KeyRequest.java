package com.zmic.index.request;

import javax.validation.constraints.NotEmpty;

/**
 * 私钥输入参数（其实就是客户端通过服务端返回的公钥加密后，客户端自己生成的公钥）
 */
public class KeyRequest {

    // 客户端自己生成的加密后的公钥
    @NotEmpty
    private String clientEncrytPublicKey;

    public String getClientEncrytPublicKey() {
        return clientEncrytPublicKey;
    }

    public void setClientEncrytPublicKey(String clientEncrytPublicKey) {
        this.clientEncrytPublicKey = clientEncrytPublicKey;
    }
}
