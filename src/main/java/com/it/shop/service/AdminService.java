package com.it.shop.service;

import com.it.shop.exception.MyException;
import com.it.shop.pojo.Admin;

import java.util.List;

public interface AdminService {

    /**
     * 登录操作
     * @param admin 登录对象
     * @return Admin实体类
     * @throws MyException 自定义异常
     */
    Admin doLogin(Admin admin) throws MyException;

    /**
     * 添加操作
     * @param admin 操作对象
     * @throws MyException 自定义异常
     */
    void addAdmin(Admin admin) throws MyException;

    void updateAdmin(Admin admin) throws MyException;

    void deleteAdminById(Integer id) throws MyException;

    Admin findAdminById(Integer id) throws MyException;

    /**
     * 根据用户名进行模糊查询
     * @return 所有符合条件的对象集合
     * @throws MyException 自定义异常
     */
    List<Admin> findAdminsLikeUsername(String keyWord) throws MyException;

}
