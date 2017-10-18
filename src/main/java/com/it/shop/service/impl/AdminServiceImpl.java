package com.it.shop.service.impl;

import com.it.shop.dao.AdminMapper;
import com.it.shop.exception.MyException;
import com.it.shop.pojo.Admin;
import com.it.shop.pojo.AdminExample;
import com.it.shop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin doLogin(Admin admin) throws MyException {

        if (admin.getUsername().equals("") || admin.getPassword().equals("")) {
            throw new MyException("用户名或密码不能为空！");
        }
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.or();
        criteria.andUsernameEqualTo(admin.getUsername())
                .andPasswordEqualTo(admin.getPassword());

        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins.size() == 0) {
            throw new MyException("用户名或密码不正确！");
        }

        return admins.get(0);
    }

    @Override
    public void addAdmin(Admin admin) throws MyException {
        adminMapper.insert(admin);
    }

    @Override
    public void updateAdmin(Admin admin) throws MyException {
        adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public void deleteAdminById(Integer id) throws MyException {
        adminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Admin findAdminById(Integer id) throws MyException {
        return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Admin> findAdminsLikeUsername(String keyWord) throws MyException {

        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.or();
        criteria.andUsernameLike(keyWord);

        return adminMapper.selectByExample(example);
    }

}
