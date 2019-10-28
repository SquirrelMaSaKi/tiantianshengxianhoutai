package com.rj.controller;

import com.rj.pojo.Goods;
import com.rj.service.GoodsService;
import com.rj.utils.RootPath;
import com.rj.utils.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/goodsList")
    @RequiresPermissions(value = {"product:query"})
    public String goodsList(HttpServletRequest request) {
        List<Goods> goods = goodsService.findAll();
        request.setAttribute("goods", goods);
        return "goodsList";
    }

    @GetMapping("/add")
    @RequiresPermissions(value = {"product:update"})
    public String addPage() {
        return "add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String[] addLogic(Goods goods, MultipartFile simg,MultipartFile bimg) throws IOException {
        String rootPath = RootPath.rootPath;
        String simgFilename = simg.getOriginalFilename();
        String bimgFilename = bimg.getOriginalFilename();
        String[] images = new String[2];

        //判断文件格式是否正确
        String sext = FilenameUtils.getExtension(simgFilename);
        String bext = FilenameUtils.getExtension(bimgFilename);


        if(!StringUtils.isEmpty(simgFilename)){
            if(((!sext.equals("png"))&&(!sext.equals("jpg"))&&(!sext.equals("gif"))) && ((!bext.equals("png"))&&(!bext.equals("jpg"))&&(!bext.equals("gif")))){
                images[0]="no";
                return images;
            }
            String newPath = rootPath+simgFilename;
            if(!new File(newPath).exists()) {
                simg.transferTo(new File(newPath));
            }
            images[0]=simgFilename;
        }
        if(!StringUtils.isEmpty(bimgFilename)){
            if(((!sext.equals("png"))&&(!sext.equals("jpg"))&&(!sext.equals("gif"))) && ((!bext.equals("png"))&&(!bext.equals("jpg"))&&(!bext.equals("gif")))){
                images[0]="no";
                return images;
            }
            String newPath = rootPath+bimgFilename;
            if(!new File(newPath).exists()) {
                bimg.transferTo(new File(newPath));
            }
            images[1]=bimgFilename;
        }
        goods.setImg(simgFilename);
        goods.setImgdetail(bimgFilename);
        goodsService.add(goods);
        return images;
    }


    @GetMapping("/show")
    @RequiresPermissions("product:query")
    public String show(Integer gid,HttpServletRequest request){
        Goods good = goodsService.findByGoodId(gid);
        request.setAttribute("good", good);
        return "goodshow";
    }

    @GetMapping("/delete")
    @RequiresPermissions("product:update")
    public String delete(Integer gid) {
        goodsService.deleteByGid(gid);
        return "redirect:/goodsList";
    }

    @GetMapping("/modify")
    @RequiresPermissions("product:update")
    public String modifyPage(Integer gid,HttpServletRequest request) {
        Goods good = goodsService.findByGoodId(gid);
        request.setAttribute("good", good);
        return "modify";
    }

    @PostMapping("/modify")
    @ResponseBody
    public String[] modifyLogic(Goods goods, MultipartFile simg,MultipartFile bimg) throws IOException {
        String rootPath = RootPath.rootPath;
        String simgFilename = simg.getOriginalFilename();
        String bimgFilename = bimg.getOriginalFilename();
        String[] images = new String[2];

        //判断文件格式是否正确
        Goods orignalGoods = goodsService.findByGoodId(goods.getId());
        String sext = FilenameUtils.getExtension(simgFilename);
        String bext = FilenameUtils.getExtension(bimgFilename);

        if(!StringUtils.isEmpty(simgFilename)){
            if(((!sext.equals("png"))&&(!sext.equals("jpg"))&&(!sext.equals("gif"))) && ((!bext.equals("png"))&&(!bext.equals("jpg"))&&(!bext.equals("gif")))){
                images[0]="no";
                return images;
            }
            String newPath = rootPath+simgFilename;
            if(!new File(newPath).exists()) {
                simg.transferTo(new File(newPath));
            }
            images[0]=simgFilename;
        } else {
            simgFilename = orignalGoods.getImg();
        }
        if(!StringUtils.isEmpty(bimgFilename)){
            if(((!sext.equals("png"))&&(!sext.equals("jpg"))&&(!sext.equals("gif"))) && ((!bext.equals("png"))&&(!bext.equals("jpg"))&&(!bext.equals("gif")))){
                images[0]="no";
                return images;
            }
            String newPath = rootPath+bimgFilename;
            if(!new File(newPath).exists()) {
                bimg.transferTo(new File(newPath));
            }
            images[1]=bimgFilename;
        } else {
            bimgFilename = orignalGoods.getImgdetail();
        }
        goods.setImg(simgFilename);
        goods.setImgdetail(bimgFilename);
        goodsService.update(goods);
        return images;
    }
}
