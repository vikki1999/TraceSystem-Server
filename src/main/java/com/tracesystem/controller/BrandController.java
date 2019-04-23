package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.Brand;
import com.tracesystem.bean.Company;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.BrandMapper;
import com.tracesystem.dao.CompanyMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘佳 on 2019-03-22 10:14
 **/
@CrossOrigin
@RestController
public class BrandController {

    @Autowired
    private BrandMapper brandMapper;

    @RequestMapping(value = "/brandList",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Brand>> findAll(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                             @RequestParam(value = "size",required = false,defaultValue = "10")int size){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<Brand>> resp = new ResponseEntity<>();
        ListResponseEntity<Brand> relist = new ListResponseEntity<>();

        relist.setList(brandMapper.findAll());
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //增加品牌信息
    @RequestMapping(value = "/addBrand",method = RequestMethod.POST)
    public ResponseEntity<Brand> addBrand(@RequestParam(value = "brandid",required = false,defaultValue = "")String brandid,
                                              @RequestParam(value = "brandname",required = false,defaultValue = "")String brandname,
                                              @RequestParam(value = "history",required = false,defaultValue = "")String history,
                                              @RequestParam(value = "category",required = false,defaultValue = "")String category,
                                              @RequestParam(value = "companyname",required = false,defaultValue = "")String companyname,
                                              @RequestParam(value = "createtime",required = false,defaultValue = "")String createtime,
                                              @RequestParam(value = "src",required = false,defaultValue = "")String src){
        ResponseEntity<Brand> resp = new ResponseEntity<>();

        System.out.println(companyname);
        String companyid;
        try{
           companyid = brandMapper.getCompanyId(companyname);

        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(30001);
            return resp;
        }

        System.out.println(companyid);

        System.out.println(companyid);
        if(StringUtils.isEmpty(brandid)||StringUtils.isEmpty(brandname)||StringUtils.isEmpty(category)
                ||StringUtils.isEmpty(createtime)||StringUtils.isEmpty(companyid)){
            resp.setCode(30001);
            return resp;
        }
        Brand brand = new Brand();
        brand.setBrandid(brandid);
        brand.setBrandname(brandname);
        brand.setCategory(category);
        brand.setHistory(history);
        brand.setCompanyid(companyid);
        brand.setCreatetime(createtime);
        brand.setSrc(src);

        System.out.println(brand);
        try{
            brandMapper.addBrand(brand);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40001);
            return resp;
        }

        resp.setCode(200);
        resp.setData(brand);
        return resp;
    }

    //修改品牌信息
    @RequestMapping(value = "/updateBrand",method = RequestMethod.POST)
    public ResponseEntity<Brand> updateBrand(@RequestParam(value = "brandid",required = false,defaultValue = "")String brandid,
                                             @RequestParam(value = "brandname",required = false,defaultValue = "")String brandname,
                                             @RequestParam(value = "history",required = false,defaultValue = "")String history,
                                             @RequestParam(value = "category",required = false,defaultValue = "")String category,
                                             @RequestParam(value = "companyname",required = false,defaultValue = "")String companyname,
                                             @RequestParam(value = "createtime",required = false,defaultValue = "")String createtime,
                                             @RequestParam(value = "src",required = false,defaultValue = "")String src){
        ResponseEntity<Brand> resp = new ResponseEntity<>();
        Brand brand = new Brand();
        Brand oringin;
        String companyid = brandMapper.getCompanyId(companyname);
        try {
            oringin = brandMapper.selectBrandById(brandid);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(30001);
            return resp;
        }
        if(StringUtils.isEmpty(brandid)){
            brand.setBrandid(oringin.getBrandid());
        }
        if(StringUtils.isEmpty(brandname)){
            brand.setBrandname(oringin.getBrandname());
        }
        if(StringUtils.isEmpty(history)){
            brand.setHistory(oringin.getHistory());
        }
        if(StringUtils.isEmpty(category)){
            brand.setCategory(oringin.getCategory());
        }
        if(StringUtils.isEmpty(createtime)){
            brand.setCreatetime(oringin.getCreatetime());
        }
        if(StringUtils.isEmpty(companyid)){
            brand.setCompanyid(oringin.getCompanyid());
        }
        brand.setBrandid(brandid);
        brand.setBrandname(brandname);
        brand.setHistory(history);
        brand.setCategory(category);
        brand.setCompanyid(companyid);
        brand.setCreatetime(createtime);
        brand.setSrc(src);
        try {
            brandMapper.updateBrand(brand);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40002);
            return resp;
        }

        resp.setCode(200);
        resp.setData(brandMapper.selectBrandById(brandid));
        return resp;
    }

    //删除品牌信息
    @RequestMapping(value = "/removeBrand",method = RequestMethod.POST)
    public ResponseEntity<Brand> removeBrand(@RequestParam(value = "id",required = true,defaultValue = "")String id){
        ResponseEntity<Brand> resp = new ResponseEntity();
        try {
            brandMapper.deleteBrand(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40003);
            return resp;
        }
        resp.setCode(200);
        return resp;

    }
}
