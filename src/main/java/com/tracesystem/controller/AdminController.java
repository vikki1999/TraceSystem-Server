package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.Admin;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.AdminMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘佳 on 2019-03-21 21:23
 **/
@CrossOrigin
@RestController
public class AdminController {

    @Autowired
    private AdminMapper adminMapper;

    @RequestMapping(value = "/adminList",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Admin>> findAll(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                             @RequestParam(value = "size",required = false,defaultValue = "10")int size,
                                                             @RequestParam(value = "companyid" ,required = false ,defaultValue = "") String companyid){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<Admin>> resp = new ResponseEntity<>();
        ListResponseEntity<Admin> relist = new ListResponseEntity<>();

        relist.setList(adminMapper.selectAdmin(companyid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //增加管理员
    @RequestMapping(value = "/insertAdmin",method = RequestMethod.POST)
    public ResponseEntity<Admin> insertAdmin(@RequestParam(value = "userid",required = true,defaultValue = "")int userid,
                                             @RequestParam(value = "ethaccount",required = false,defaultValue = "")String ethaccount,
                                             @RequestParam(value = "ethpwd",required = false,defaultValue = "")String ethpwd){
        ResponseEntity<Admin> resp = new ResponseEntity<>();
        Admin admin = new Admin();
        admin.setEthpwd(ethpwd);
        admin.setEthaccount(ethaccount);
        admin.setUserid(userid);

        try {
            adminMapper.insertAdmin(admin);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40002);
            return resp;
        }

        resp.setCode(200);
        return resp;
    }
    //修改管理员信息
    @RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
    public ResponseEntity<Admin> updateAdmin(@RequestParam(value = "adminid",required = true,defaultValue = "")int adminid,
                                                  @RequestParam(value = "ethaccount",required = false,defaultValue = "")String ethaccount,
                                                  @RequestParam(value = "ethpwd",required = false,defaultValue = "")String ethpwd){
        ResponseEntity<Admin> resp = new ResponseEntity<>();
        Admin admin = new Admin();
        Admin oringin;
        try {
            oringin = adminMapper.selectAdminById(adminid);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(30001);
            return resp;
        }

        admin.setAdminid(adminid);
        if(StringUtils.isEmpty(ethaccount)){
            admin.setEthaccount(oringin.getEthaccount());
        }else {
            admin.setEthaccount(ethaccount);
        }
        if(StringUtils.isEmpty(ethpwd)){
            admin.setEthpwd(oringin.getEthpwd());
        }else{
            admin.setEthpwd(ethpwd);
        }
        System.out.println(admin.toString());
        try {
            adminMapper.updateAdmin(admin);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40002);
            return resp;
        }

        resp.setCode(200);
        resp.setData(adminMapper.selectAdminById(adminid));
        return resp;
    }

    //删除管理员
    @RequestMapping(value = "/removeAdmin",method = RequestMethod.POST)
    public ResponseEntity<Admin> removeAdmin(@RequestParam(value = "id",required = true,defaultValue = "")int id){
        ResponseEntity<Admin> resp = new ResponseEntity();
        try {
            adminMapper.deleteAdmin(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40003);
            return resp;
        }
        resp.setCode(200);
        return resp;

    }
}
