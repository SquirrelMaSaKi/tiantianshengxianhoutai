package com.rj.dao;

import com.rj.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    Admin findByUsernameOrEmail(@Param("ue") String ue);
}
