package com.it.shop.common;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {

    private int errorCode;

    private String message;

    private Map<String, Object> item = new HashMap<>();

    public JsonResult(){}

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getItme() {
        return item;
    }

    public void setItem(Map<String, Object> itme) {
        this.item = item;
    }
}