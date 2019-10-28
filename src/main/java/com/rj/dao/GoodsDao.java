package com.rj.dao;

import com.rj.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsDao {
    List<Goods> findAll();
    Goods findByGoodId(@Param("goodId") Integer goodId);
    void add(Goods goods);

    void deleteByGid(@Param("gid") Integer gid);

    void update(Goods goods);
}
