package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.Menu;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 刘佳 on 2019-03-27 10:27
 **/
@CrossOrigin
@RestController
public class MenuController {

    @Autowired
    private MenuMapper menuMapper;

    @RequestMapping(value = "/findMenu",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Menu>> findMenus(@RequestParam(value = "moudelid",required = true,defaultValue = "50000")String moudelid) {


        ResponseEntity<ListResponseEntity<Menu>> resp = new ResponseEntity<>();
        ListResponseEntity<Menu> relist = new ListResponseEntity<>();
        List<Menu> menu = menuMapper.findMenu(moudelid);
        List list;

        for( int i = 0 ; i < menu.size() ; i++) {//内部不锁定，效率最高，但在多线程要考虑并发操作的问题。
            System.out.println(menu.get(i).toString());

        }
        relist.setList(menu);
        resp.setCode(200);
        resp.setData(relist);
        return resp;
    }

    @RequestMapping(value = "/getChildren",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Menu>> getMenuChildren(@RequestParam(value = "key",required = true,defaultValue = "")String key,
                                                                    @RequestParam(value = "moudelid",required = true,defaultValue = "50000")String moudelid){

        ResponseEntity<ListResponseEntity<Menu>> resp = new ResponseEntity<>();
        ListResponseEntity<Menu> relist = new ListResponseEntity<>();

        relist.setList(menuMapper.findChildrenMenu(key,moudelid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

}

