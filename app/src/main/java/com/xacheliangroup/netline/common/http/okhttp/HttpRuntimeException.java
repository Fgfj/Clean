package com.xacheliangroup.netline.common.http.okhttp;

/**
 * Created by yangshuai on 2017/8/19.
 * {link http://afra55.github.io}
 */

public class HttpRuntimeException extends RuntimeException {
    private String errorCode;
    private String errorMsg;


    public HttpRuntimeException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }


    public String getErrorMsg() {
        return errorMsg;
    }
}