package com.rj.service;

import com.rj.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    List<Goods> findAll();
    Goods findByGoodId(@Param("goodId") Integer goodId);
    void add(Goods goods);

    void deleteByGid(Integer gid);

    void update(Goods goods);
}
