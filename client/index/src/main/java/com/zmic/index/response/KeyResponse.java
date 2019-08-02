package com.zmic.index.response;

/**
 * 私钥输入参数
 */
public class KeyResponse {

    // 整个系统所有加密算法公用的密钥
    private String key;

    public static class Builder{
        private String key;

        public Builder setKey(String key) {
            this.key = key;
            return this;
        }

        public KeyResponse build(){
            return new KeyResponse(this);
        }
    }

    public static Builder options(){
        return new Builder();
    }

    public KeyResponse(Builder builder) {
        this.key = builder.key;
    }

    public String getKey() {
        return key;
    }
}
