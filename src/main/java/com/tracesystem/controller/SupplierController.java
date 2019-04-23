package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.Supplier;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘佳 on 2019-04-16 21:59
 **/
@CrossOrigin
@RestController
public class SupplierController {
    @Autowired
    private SupplierMapper supplierMapper;

    @RequestMapping(value = "/getAllSuppliers",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Supplier>> getAllSuppliers(){
        ResponseEntity<ListResponseEntity<Supplier>> resp = new ResponseEntity<>();
        ListResponseEntity<Supplier> relist = new ListResponseEntity<>();

        relist.setList(supplierMapper.getAllSuppliers());
        resp.setCode(200);
        resp.setData(relist);
        return resp;
    }

    @RequestMapping(value = "/getSuppliers",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Supplier>> findAll(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                                   @RequestParam(value = "size",required = false,defaultValue = "10")int size,
                                                                   @RequestParam(value = "companyid",required = true,defaultValue = "")String companyid){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<Supplier>> resp = new ResponseEntity<>();
        ListResponseEntity<Supplier> relist = new ListResponseEntity<>();

        relist.setList(supplierMapper.getSuppliers(companyid));
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }
}
