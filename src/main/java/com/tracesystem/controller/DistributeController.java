package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.Distribute;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.DistributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘佳 on 2019-03-22 10:14
 **/
@CrossOrigin
@RestController
public class DistributeController {
    @Autowired
    private DistributeMapper distributeMapper;

    @RequestMapping(value = "/distributeList",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Distribute>> findAll(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                                  @RequestParam(value = "size",required = false,defaultValue = "10")int size,
                                                                  @RequestParam(value = "companyid",required = true,defaultValue = "")String companyid){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<Distribute>> resp = new ResponseEntity<>();
        ListResponseEntity<Distribute> relist = new ListResponseEntity<>();

        relist.setList(distributeMapper.findAll(companyid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //增加分销商
    @RequestMapping(value = "/addDistribute",method = RequestMethod.POST)
    public ResponseEntity<Distribute> addDistribute(@RequestParam(value = "distributeid",required = false,defaultValue = "")String distributeid,
                                                    @RequestParam(value = "distributename",required = false,defaultValue = "")String distributename,
                                                    @RequestParam(value = "address",required = false,defaultValue = "")String address,
                                                    @RequestParam(value = "companyid",required = false,defaultValue = "")String companyid,
                                                    @RequestParam(value = "createdate",required = false,defaultValue = "")String createdate){
        ResponseEntity<Distribute> resp = new ResponseEntity<>();
        if(StringUtils.isEmpty(distributeid)){
            resp.setCode(30001);
            return resp;
        }
        Distribute distribute = new Distribute();
        distribute.setAddress(address);
        distribute.setCreatedate(createdate);
        distribute.setCompanyid(companyid);
        distribute.setDistributeid(distributeid);
        distribute.setDistributename(distributename);

        System.out.println(distributeid);
        try{
            distributeMapper.addDistribute(distribute);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40001);
            return resp;
        }

        resp.setCode(200);
        resp.setData(distribute);
        return resp;
    }

    //修改
    @RequestMapping(value = "/updateDistribute",method = RequestMethod.POST)
    public ResponseEntity<Distribute> updateDistribute(@RequestParam(value = "distributeid",required = false,defaultValue = "")String distributeid,
                                                       @RequestParam(value = "distributename",required = false,defaultValue = "")String distributename,
                                                       @RequestParam(value = "address",required = false,defaultValue = "")String address,
                                                       @RequestParam(value = "companyid",required = false,defaultValue = "")String companyid,
                                                       @RequestParam(value = "createdate",required = false,defaultValue = "")String createdate){
        ResponseEntity<Distribute> resp = new ResponseEntity<>();
        Distribute distribute = new Distribute();
        Distribute oringin = new Distribute();
        try {
            oringin = distributeMapper.selectDistributeById(distributeid);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(30001);
            return resp;
        }
        if(StringUtils.isEmpty(distributeid)){
            distribute.setDistributeid(oringin.getDistributeid());
        }else {
            distribute.setDistributeid(distributeid);
        }
        if(StringUtils.isEmpty(distributename)){
            distribute.setDistributename(oringin.getDistributename());
        }else{
            distribute.setDistributename(distributename);
        }
        if(StringUtils.isEmpty(companyid)){
            distribute.setCompanyid(oringin.getCompanyid());
        }else {
            distribute.setCompanyid(companyid);
        }
        if(StringUtils.isEmpty(createdate)){
            distribute.setCreatedate(oringin.getCreatedate());
        }else {
            distribute.setCreatedate(createdate);
        }
        if(StringUtils.isEmpty(address)){
            distribute.setAddress(oringin.getAddress());
        }else {
            distribute.setAddress(address);
        }
        try {
            distributeMapper.updateDistribute(distribute);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40002);
            return resp;
        }

        resp.setCode(200);
        resp.setData(distributeMapper.selectDistributeById(distributeid));
        return resp;
    }

    //删除
    @RequestMapping(value = "/removeDistribute",method = RequestMethod.POST)
    public ResponseEntity<Distribute> removeDistribute(@RequestParam(value = "id",required = true,defaultValue = "")String id){
        ResponseEntity<Distribute> resp = new ResponseEntity();
        try {
            distributeMapper.deleteDistribute(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40003);
            return resp;
        }
        resp.setCode(200);
        return resp;

    }
}
