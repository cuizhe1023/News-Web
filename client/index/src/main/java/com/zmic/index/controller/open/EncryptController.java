package com.zmic.index.controller.open;

import com.zemic.common.annotation.DisabledEncrypt;
import com.zemic.common.result.SingleResult;
import com.zmic.index.request.KeyRequest;
import com.zmic.index.response.KeyResponse;
import com.zmic.index.response.RSAResponse;
import com.zmic.index.service.EncryptOpenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/open/encrypt")
public class EncryptController {

    private EncryptOpenService encryptOpenService;

    @PostMapping("getRSA")
    @DisabledEncrypt
    public SingleResult<RSAResponse> getRSA() {
        return encryptOpenService.getRSA();
    }

    @PostMapping("getKey")
    @DisabledEncrypt
    public SingleResult<KeyResponse> getKey(@Valid @RequestBody KeyRequest request) throws Exception {
        return encryptOpenService.getKey(request);
    }
}
