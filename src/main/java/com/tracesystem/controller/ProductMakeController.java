package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.ProductMake;
import com.tracesystem.bean.Technology;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.ProductMakeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘佳 on 2019-04-10 11:04
 **/
@CrossOrigin
@RestController
public class ProductMakeController {
    @Autowired
    private ProductMakeMapper productMakeMapper;

    @RequestMapping(value = "/traceProduct",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<ProductMake>> findAll(
                                                                   @RequestParam(value = "traceid",required = true,defaultValue = "")String traceid){


        ResponseEntity<ListResponseEntity<ProductMake>> resp = new ResponseEntity<>();
        ListResponseEntity<ProductMake> relist = new ListResponseEntity<>();

        relist.setList(productMakeMapper.findAll(traceid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }
    @RequestMapping(value = "/productMakeList",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<ProductMake>> productMakeList(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                                           @RequestParam(value = "size",required = false,defaultValue = "10")int size,
                                                                           @RequestParam(value = "companyid",required = true,defaultValue = "")String companyid){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<ProductMake>> resp = new ResponseEntity<>();
        ListResponseEntity<ProductMake> relist = new ListResponseEntity<>();

        relist.setList(productMakeMapper.queryProductMakeList(companyid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;


    }
    @RequestMapping(value = "/getOneProductmake",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<ProductMake>> getOneProductmake(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                                           @RequestParam(value = "size",required = false,defaultValue = "10")int size,
                                                                           @RequestParam(value = "productmakeid",required = true,defaultValue = "")String productmakeid){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<ProductMake>> resp = new ResponseEntity<>();
        ListResponseEntity<ProductMake> relist = new ListResponseEntity<>();

        relist.setList(productMakeMapper.querySingleProductMake(productmakeid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;


    }

}

