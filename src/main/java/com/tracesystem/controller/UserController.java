package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.User;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.UserMapper;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘佳 on 2019-02-15 15:57
 **/

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    //登陆
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestParam(value = "username",required = true,defaultValue = "")String username,
                                      @RequestParam(value = "password",required = true,defaultValue = "")String password){
        ResponseEntity<User> resp = new ResponseEntity<>();
        User user = new User();

        try {
           user  = userMapper.login(username,password);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(10001);
            return resp;
        }
        if(user == null){
            resp.setCode(10001);
            return resp;
        }
        resp.setCode(200);
        resp.setData(user);
        return resp;
    }
    //地区
    @RequestMapping(value = "getLocals",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<String>> getLocals(){
        ResponseEntity<ListResponseEntity<String>> resp = new ResponseEntity<>();
        ListResponseEntity<String> relist = new ListResponseEntity<>();
        relist.setList(userMapper.getLocal());
        resp.setCode(200);
        resp.setData(relist);
        return resp;
    }
    //设置管理员
    @RequestMapping(value = "setAdmin",method = RequestMethod.POST)
    public ResponseEntity<User> setAdmin(@RequestParam(value = "userid",required = true,defaultValue = "")int userid){
        ResponseEntity<User> resp = new ResponseEntity<>();
        userMapper.setAdmin(userid);
        resp.setData(userMapper.selectUserById(userid));
        resp.setCode(200);
        return resp;
    }

    //查找
    @RequestMapping(value="/search",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<User>> search(@RequestParam(value = "id",required = false,defaultValue = "")String id,
                                                           @RequestParam(value = "keyword",required = false,defaultValue = "") String keyword,
                                                           @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                           @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
        PageHelper.startPage(page,size);
        Map<String, Object> params = new HashMap<>();

        if(StringUtils.isNotEmpty(id)){
            params.put("id",id);
        }
        if(StringUtils.isNotEmpty(keyword)){
            params.put("keyword",keyword);
        }
        ResponseEntity<ListResponseEntity<User>> resp = new ResponseEntity<>();
        ListResponseEntity<User> relist = new ListResponseEntity<>();
        relist.setList(userMapper.search(params));

        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //查找设计师
    @RequestMapping(value="/selectDesigner",method=RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<User>> selectAdmin(@RequestParam(value = "page",required = false,defaultValue = "1")Integer page,
                                                                @RequestParam(value = "size",required = false,defaultValue = "10")Integer size,
                                                                @RequestParam(value = "companyid" ,required = false ,defaultValue = "") String companyid){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<User>> resp = new ResponseEntity();
        ListResponseEntity<User> relist = new ListResponseEntity<>();
        relist.setList(userMapper.selectDesigner(companyid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //通过id查找用户
    @RequestMapping(value = "/selectUserById",method = RequestMethod.POST)
    public ResponseEntity<User> selectUserById(@RequestParam(value = "id",required = false,defaultValue = "") String id){
        ResponseEntity<User> resp = new ResponseEntity<>();
        User user = userMapper.selectUserById(Integer.parseInt(id));
        resp.setData(user);
        resp.setCode(200);
        return resp;
    }


    //通过账号查找用户
    @RequestMapping(value = "/selectUserByName",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<User>> selectUserByName(@RequestParam(value = "name",required = false,defaultValue = "") String name,
                                                                     @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                                     @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<User>> resp = new ResponseEntity<>();
        ListResponseEntity<User> relist = new ListResponseEntity<>();
        relist.setList(userMapper.selectUserByName(name));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //查找所有用户
    @RequestMapping(value = "/userList",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<User>> findAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                                            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                                                            @RequestParam(value = "companyid",required = true,defaultValue = "")String companyid){
        PageHelper.startPage(page, size);

        ResponseEntity<ListResponseEntity<User>> resp = new ResponseEntity<>();
        ListResponseEntity<User> relist = new ListResponseEntity<>();
        relist.setList(userMapper.findAll(companyid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //新增用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestParam(value = "username",required = false,defaultValue = "") String username,
                                        @RequestParam(value = "loginpwd",required = false,defaultValue = "") String loginpwd,
                                        @RequestParam(value = "mobilephone",required = false,defaultValue = "") String mobilephone,
                                        @RequestParam(value = "email",required = false,defaultValue = "") String email,
                                        @RequestParam(value = "permissions",required = false,defaultValue = "1") String permissions,
                                        @RequestParam(value = "local",required = false,defaultValue = "") String local,
                                        @RequestParam(value = "gender",required = false,defaultValue = "") String gender,
                                        @RequestParam(value = "createtime" ,required = false ,defaultValue = "") String createtime,
                                        @RequestParam(value = "roleid" ,required = false ,defaultValue = "") String roleid,
                                        @RequestParam(value = "companyid" ,required = false ,defaultValue = "") String companyid){
        ResponseEntity<User> resp = new ResponseEntity<>();
        User user = new User();
        System.out.println(username);
        if(StringUtils.isNotEmpty(username)){
            user.setUsername(username);
        }
        System.out.println(loginpwd);
        if(StringUtils.isNotEmpty(loginpwd)){
            user.setLoginpwd(loginpwd);
        }
        if(StringUtils.isNotEmpty(mobilephone)){
            user.setMobilephone(mobilephone);
        }
        if(StringUtils.isNotEmpty(email)){
            user.setEmail(email);
        }
        if(StringUtils.isNotEmpty(permissions)){
            user.setPermissions(permissions);
        }
        if(StringUtils.isNotEmpty(local)){
            user.setLocal(local);
        }
        if(StringUtils.isNotEmpty(gender)){
            user.setGender(gender);
        }
        user.setRoleid(roleid);
        user.setCompanyid(companyid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        createtime = sdf.format(new Date());
        user.setCreatetime(createtime);

        System.out.println(user);
        try{
            userMapper.addUser(user);
        }catch (Exception e){

            System.out.println(e.getMessage());
            resp.setCode(40001);
            return resp;
        }
        resp.setData(user);
        resp.setCode(200);
        return resp;

    }

    //删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public ResponseEntity<User> deleteUser(@RequestParam(value = "id" ,required = true ,defaultValue = "" ) String id){
        ResponseEntity<User> resp = new ResponseEntity<>();

        if(StringUtils.isEmpty(id)){
            resp.setCode(30001);
            return resp;
        }
        User user = userMapper.selectUserById(Integer.parseInt(id));
        if(user == null){
            resp.setCode(30001);
        }
        try {
            userMapper.deleteUser(Integer.parseInt(id));
        }catch (Exception e) {
           System.out.println(e.getMessage());
            resp.setCode(40003);
            return resp;
        }
        resp.setCode(200);
        return resp;
    }

    //修改用户
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestParam(value = "userid",required = true , defaultValue = "")Integer userid,
                                           @RequestParam(value = "username",required = false,defaultValue = "") String username,
                                           @RequestParam(value = "loginpwd",required = false,defaultValue = "") String loginpwd,
                                           @RequestParam(value = "mobilephone",required = false,defaultValue = "") String mobilephone,
                                           @RequestParam(value = "email",required = false,defaultValue = "") String email,
                                           @RequestParam(value = "permissions",required = false,defaultValue = "") String permissions,
                                           @RequestParam(value = "local",required = false,defaultValue = "") String local,
                                           @RequestParam(value = "gender",required = false,defaultValue = "") String gender,
                                           @RequestParam(value = "createtime" ,required = false , defaultValue = "") String createtime,
                                           @RequestParam(value = "roleid" ,required = false ,defaultValue = "") String roleid,
                                           @RequestParam(value = "companyid" ,required = false ,defaultValue = "") String companyid){
        ResponseEntity<User> resp = new ResponseEntity<>();
        if(userid == null){
            resp.setCode(30001);
            return resp;
        }
        User oringin = userMapper.selectUserById(userid);

        System.out.println(oringin);
        System.out.println(userid);
        System.out.println(local);
        User user = new User();
        user.setUserid(userid);
        if (StringUtils.isEmpty(email)){
            user.setEmail(oringin.getEmail());
        }else{
            user.setEmail(email.trim());
        }
        if (StringUtils.isEmpty(loginpwd)){
            user.setLoginpwd(oringin.getLoginpwd());
        }else{user.setLoginpwd(loginpwd.trim());}
        if (StringUtils.isEmpty(mobilephone)){
            user.setMobilephone(oringin.getMobilephone());
        }else{user.setMobilephone(mobilephone.trim());}
        if (StringUtils.isEmpty(username)){
            user.setUsername(oringin.getUsername());
        }else{user.setUsername(username.trim());}
        if (StringUtils.isEmpty(permissions)){
            user.setPermissions(oringin.getPermissions());
        }else{user.setPermissions(permissions.trim());}
        if (StringUtils.isEmpty(createtime)){
            user.setCreatetime(oringin.getCreatetime());
        }else{user.setCreatetime(createtime.trim());}
        if (StringUtils.isEmpty(gender)){
            user.setGender(oringin.getGender());
        }else{user.setGender(gender.trim());}
        if (StringUtils.isEmpty(local)){
            user.setLocal(oringin.getLocal());
        }else{user.setLocal(local.trim());}
        if (StringUtils.isEmpty(roleid)){
            user.setRoleid(oringin.getRoleid());
        }else{user.setRoleid(roleid.trim());}
        if (StringUtils.isEmpty(companyid)){
            user.setCompanyid(oringin.getCompanyid());
        }else{user.setCompanyid(companyid.trim());}

        System.out.println(user);
        try{
            userMapper.updateUser(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40002);
            return resp;
        }
        resp.setData(userMapper.selectUserById(userid));
        resp.setCode(200);
        return resp;

    }

}
