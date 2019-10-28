package com.rj.service.impl;

import com.rj.dao.GoodsDao;
import com.rj.dao.GoodsTypeDao;
import com.rj.pojo.Goods;
import com.rj.pojo.GoodsType;
import com.rj.service.GoodsService;
import com.rj.utils.RootPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsTypeDao goodsTypeDao;

    @Override
    public List<Goods> findAll() {
        List<Goods> goods = goodsDao.findAll();
        for (Goods good : goods) {
            GoodsType goodsType = goodsTypeDao.findById(good.getTypeid());
            good.setTypename(goodsType.getTypename());
        }
        return goods;
    }

    @Override
    public Goods findByGoodId(Integer goodId) {
        Goods good = goodsDao.findByGoodId(goodId);
        GoodsType goodsType = goodsTypeDao.findById(good.getTypeid());
        good.setTypename(goodsType.getTypename());
        return good;
    }

    @Override
    public void add(Goods goods) {
        goodsDao.add(goods);
    }

    @Override
    public void deleteByGid(Integer gid) {
        Goods good = goodsDao.findByGoodId(gid);
        String finalPath1 = RootPath.rootPath+good.getImg();
        String finalPath2 = RootPath.rootPath+good.getImgdetail();
        new File(finalPath1).delete();
        new File(finalPath2).delete();
        goodsDao.deleteByGid(gid);
    }

    @Override
    public void update(Goods goods) {
        goodsDao.update(goods);
    }
}
