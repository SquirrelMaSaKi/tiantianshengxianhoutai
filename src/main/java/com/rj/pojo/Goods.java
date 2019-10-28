package com.rj.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private Integer typeid;
    private String goodsname;
    private String introduce;
    private BigDecimal price;
    private String company;
    private String subtitle;
    private String img;
    private String imgdetail;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date upshelf;
    private Integer hot;
    private String typename;
}
