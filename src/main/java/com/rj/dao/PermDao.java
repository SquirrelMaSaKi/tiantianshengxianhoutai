package com.rj.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface PermDao {
    Set<String> permNames(@Param("ue") String ue);
}
