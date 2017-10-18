package com.it.shop.controller;

import com.it.shop.common.JsonResult;
import com.it.shop.controller.base.BaseController;
import com.it.shop.exception.MyException;
import com.it.shop.pojo.Admin;
import com.it.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/shop")
public class UserController extends BaseController {

    @Autowired
    private AdminService adminService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult doLogin(Admin admin, HttpSession session) {

        try {
            Admin currAdmin = adminService.doLogin(admin);
            jsonResult.setErrorCode(200);
            dataMap.put("user", currAdmin);
            jsonResult.setItem(dataMap);
            jsonResult.setMessage("登陆成功！");
        } catch (Exception e) {
            jsonResult.setErrorCode(500);
            jsonResult.setMessage(e.getMessage());
        }

        return jsonResult;
    }


    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public JsonResult addAdmin(Admin admin, @RequestParam String repassword) {

        try {
            adminService.addAdmin(admin);
            jsonResult.setErrorCode(200);
            jsonResult.setMessage("操作成功！");
        } catch (MyException e) {
            jsonResult.setErrorCode(500);
            jsonResult.setMessage(e.getMessage());
        }

        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public JsonResult updateAdmin(Admin admin) {
        try {
            adminService.updateAdmin(admin);
            jsonResult.setErrorCode(200);
            jsonResult.setMessage("操作成功！");
        } catch (MyException e) {
            jsonResult.setErrorCode(500);
            jsonResult.setMessage(e.getMessage());
        }
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public JsonResult findAdminLikeUsername(@RequestParam String keyWord) {

        try {
            List<Admin> admins = adminService.findAdminsLikeUsername(keyWord);
            dataMap.put("admins", admins);
            jsonResult.setItem(dataMap);
            jsonResult.setErrorCode(200);
        } catch (MyException e) {
            jsonResult.setErrorCode(500);
            jsonResult.setMessage(e.getMessage());
        }

        return jsonResult;
    }

}
