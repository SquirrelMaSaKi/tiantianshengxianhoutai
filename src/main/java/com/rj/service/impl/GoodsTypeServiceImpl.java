package com.rj.service.impl;

import com.rj.dao.GoodsTypeDao;
import com.rj.pojo.GoodsType;
import com.rj.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("goodsTypeService")
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeDao goodsTypeDao;
    @Override
    public List<GoodsType> findAll() {
        return goodsTypeDao.findAll();
    }

    @Override
    public GoodsType findById(Integer typeid) {
        return goodsTypeDao.findById(typeid);
    }
}
