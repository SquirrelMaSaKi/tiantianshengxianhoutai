package com.rj.service.impl;

import com.rj.dao.AdminDao;
import com.rj.pojo.Admin;
import com.rj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin findByUsernameOrEmail(String ue) {
        return adminDao.findByUsernameOrEmail(ue);
    }
}
