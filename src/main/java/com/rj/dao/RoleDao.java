package com.rj.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface RoleDao {
    Set<String> roleNames(@Param("ue") String ue);
}
