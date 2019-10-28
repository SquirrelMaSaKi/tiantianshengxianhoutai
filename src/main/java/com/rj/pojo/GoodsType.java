package com.rj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsType implements Serializable {
    private Integer id;
    private String typename;
    private Date createtime;
    private String icon;
    private String headimg;
}
