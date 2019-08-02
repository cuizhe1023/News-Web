package com.zmic.index.service;

import com.zemic.common.result.SingleResult;
import com.zemic.common.utils.RSAUtils;
import com.zmic.index.request.KeyRequest;
import com.zmic.index.response.KeyResponse;
import com.zmic.index.response.RSAResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EncryptOpenService {

    @Value("${rsa.publicKey}")
    private String publicKey;

    @Value("${rsa.privateKey}")
    private String privateKey;

    @Value("${rsa.encrypt.key}")
    private String key;

    public SingleResult<RSAResponse> getRSA() {
        RSAResponse response = RSAResponse.options().setServerPublicKey(publicKey).build();
        return SingleResult.buildSuccess(response);
    }

    public SingleResult<KeyResponse> getKey(KeyRequest request) throws Exception {
        String clinePublicKey  = RSAUtils.privateDecrypt(request.getClientEncrytPublicKey(),RSAUtils.getPrivateKey(privateKey));
        String encryptKey = RSAUtils.publicEncrypt(key,RSAUtils.getPublicKey(clinePublicKey));
        KeyResponse response = KeyResponse.options().setKey(encryptKey).build();
        return SingleResult.buildSuccess(response);
    }
}
