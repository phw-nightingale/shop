package com.it.shop.controller.base;

import com.it.shop.common.JsonResult;

import java.util.HashMap;
import java.util.Map;


public class BaseController {

    public static JsonResult jsonResult = new JsonResult();

    public Map<String, Object> dataMap = new HashMap<>();

    
}
