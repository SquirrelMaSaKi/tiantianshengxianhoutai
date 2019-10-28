package com.rj.service;

import com.rj.pojo.Admin;

public interface AdminService {
    Admin findByUsernameOrEmail(String ue);
}
