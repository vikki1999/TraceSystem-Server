package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.Technology;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.TechnologyMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘佳 on 2019-02-24 14:48
 **/
@CrossOrigin
@RestController
public class TechnologyController {

    @Autowired
    private TechnologyMapper technologyMapper;

    @RequestMapping(value = "/technologyList",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Technology>> findAll(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                                  @RequestParam(value = "size",required = false,defaultValue = "10")int size,
                                                                  @RequestParam(value = "companyid",required = true,defaultValue = "")String companyid){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<Technology>> resp = new ResponseEntity<>();
        ListResponseEntity<Technology> relist = new ListResponseEntity<>();

        relist.setList(technologyMapper.findAll(companyid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //增加工艺
    @RequestMapping(value = "/addTechnology",method = RequestMethod.POST)
    public ResponseEntity<Technology> addTechnology(@RequestParam(value = "technologyname",required = false,defaultValue = "")String technologyname,
                                                    @RequestParam(value = "note",required = false,defaultValue = "")String note,
                                                    @RequestParam(value = "patentid",required = false,defaultValue = "")String patentid,
                                                    @RequestParam(value = "patentcategory",required = false,defaultValue = "")String patentcategory,
                                                    @RequestParam(value = "companyid",required = false,defaultValue = "")String companyid){
        ResponseEntity<Technology> resp = new ResponseEntity<>();
        if(StringUtils.isEmpty(technologyname)){
            resp.setCode(30001);
            return resp;
        }
        Technology technology = new Technology();
        technology.setTechnologyname(technologyname);
        technology.setNote(note);
        technology.setCompanyid(companyid);
        technology.setPatentcategory(patentcategory);
        technology.setPatentid(patentid);

        System.out.println(technology);
        try{
            technologyMapper.addTechnology(technology);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40001);
            return resp;
        }

        resp.setCode(200);
        resp.setData(technology);
        return resp;
    }

    //修改工艺
    @RequestMapping(value = "/updateTechnology",method = RequestMethod.POST)
    public ResponseEntity<Technology> updateTechnology(@RequestParam(value = "technologyid",required = true,defaultValue = "")int technologyid,
                                                       @RequestParam(value = "technologyname",required = false,defaultValue = "")String technologyname,
                                                       @RequestParam(value = "note",required = false,defaultValue = "")String note,
                                                       @RequestParam(value = "patentid",required = false,defaultValue = "")String patentid,
                                                       @RequestParam(value = "patentcategory",required = false,defaultValue = "")String patentcategory,
                                                       @RequestParam(value = "companyid",required = false,defaultValue = "")String companyid){
        ResponseEntity<Technology> resp = new ResponseEntity<>();
        Technology technology = new Technology();
        Technology oringin = new Technology();
        try {
            oringin = technologyMapper.selectTechnologyById(technologyid);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(30001);
            return resp;
        }
        if(StringUtils.isEmpty(technologyname)){
            technology.setTechnologyname(oringin.getTechnologyname());
        }else {
            technology.setTechnologyname(technologyname);
        }
        if(StringUtils.isEmpty(note)){
            technology.setNote(oringin.getNote());
        }else{
            technology.setNote(note);
        }
        if(StringUtils.isEmpty(patentcategory)){
            technology.setPatentcategory(oringin.getPatentcategory());
        }else {
            technology.setPatentcategory(patentcategory);
        }
        if(StringUtils.isEmpty(patentid)){
            technology.setPatentid(oringin.getPatentid());
        }else {
            technology.setPatentid(patentid);
        }
        if(StringUtils.isEmpty(companyid)){
            technology.setCompanyid(oringin.getCompanyid());
        }else {
            technology.setCompanyid(companyid);
        }
        try {
            technologyMapper.updateTechnology(technology);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40002);
            return resp;
        }

        resp.setCode(200);
        resp.setData(technologyMapper.selectTechnologyById(technologyid));
        return resp;
    }

    //删除工艺
    @RequestMapping(value = "/removeTechnology",method = RequestMethod.POST)
    public ResponseEntity<Technology> removeTechnology(@RequestParam(value = "id",required = true,defaultValue = "")int id){
        ResponseEntity<Technology> resp = new ResponseEntity();
        try {
            technologyMapper.deleteTechnology(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40003);
            return resp;
        }
        resp.setCode(200);
        return resp;

    }
}
