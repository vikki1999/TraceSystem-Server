package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.Role;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘佳 on 2019-04-07 11:18
 **/
@CrossOrigin
@RestController
public class RoleController {

    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping(value = "roleList",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Role>> roleList(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                             @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<Role>> resp = new ResponseEntity<>();
        ListResponseEntity<Role> relist = new ListResponseEntity<>();

        try {
            relist.setList(roleMapper.queryRoleList());
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(10000);
            return resp;
        }
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    @RequestMapping(value = "getRoleById",method = RequestMethod.POST)
    public ResponseEntity<Role> getRoleById(@RequestParam(value = "id",required = false,defaultValue = "") String id){
        ResponseEntity<Role> resp = new ResponseEntity<>();
        Role role = roleMapper.selectRoleById(id);
        resp.setData(role);
        resp.setCode(200);
        return resp;
    }
}

