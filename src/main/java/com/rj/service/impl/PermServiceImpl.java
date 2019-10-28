package com.rj.service.impl;

import com.rj.dao.PermDao;
import com.rj.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("permService")
public class PermServiceImpl implements PermService {
    @Autowired
    private PermDao permDao;
    @Override
    public Set<String> permNames(String ue) {
        return permDao.permNames(ue);
    }
}
