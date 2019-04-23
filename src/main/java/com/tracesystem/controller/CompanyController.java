package com.tracesystem.controller;

import com.github.pagehelper.PageHelper;
import com.tracesystem.bean.Company;
import com.tracesystem.bean.Technology;
import com.tracesystem.common.ListResponseEntity;
import com.tracesystem.common.ResponseEntity;
import com.tracesystem.dao.CompanyMapper;
import com.tracesystem.dao.TechnologyMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 刘佳 on 2019-03-21 21:24
 **/
@CrossOrigin
@RestController
public class CompanyController {

    @Autowired
    private CompanyMapper companyMapper;

    @RequestMapping(value = "/companyList",method = RequestMethod.POST)
    public ResponseEntity<ListResponseEntity<Company>> findAll(@RequestParam(value = "page",required = false,defaultValue = "1")int page,
                                                               @RequestParam(value = "size",required = false,defaultValue = "10")int size){
        PageHelper.startPage(page,size);

        ResponseEntity<ListResponseEntity<Company>> resp = new ResponseEntity<>();
        ListResponseEntity<Company> relist = new ListResponseEntity<>();

        relist.setList(companyMapper.findAll());
        resp.setData(relist);
        resp.setCode(200);
        return resp;
    }

    //增加企业信息
    @RequestMapping(value = "/addCompany",method = RequestMethod.POST)
    public ResponseEntity<Company> addCompany(@RequestParam(value = "companyid",required = false,defaultValue = "")String companyid,
                                                 @RequestParam(value = "companyname",required = false,defaultValue = "")String companyname,
                                                 @RequestParam(value = "address",required = false,defaultValue = "")String address,
                                                 @RequestParam(value = "abbreviation",required = false,defaultValue = "")String abbreviation,
                                                 @RequestParam(value = "certificate",required = false,defaultValue = "")String certificate,
                                                 @RequestParam(value = "createtime",required = false,defaultValue = "")String createtime,
                                                 @RequestParam(value = "parentid",required = false,defaultValue = "")String parentid){
        ResponseEntity<Company> resp = new ResponseEntity<>();
        if(StringUtils.isEmpty(companyid)){
            resp.setCode(30001);
            return resp;
        }else if(StringUtils.isEmpty(companyname)){
            resp.setCode(30001);
            return resp;
        }else if(StringUtils.isEmpty(address)){
            resp.setCode(30001);
            return resp;
        }else if(StringUtils.isEmpty(abbreviation)){
            resp.setCode(30001);
            return resp;
        }else if(StringUtils.isEmpty(certificate)){
            resp.setCode(30001);
            return resp;
        }else if(StringUtils.isEmpty(createtime)){
            resp.setCode(30001);
            return resp;
        }
        Company company = new Company();
        company.setAbbreviation(abbreviation);
        company.setAddress(address);
        company.setCertificate(certificate);
        company.setCompanyid(companyid);
        company.setCompanyname(companyname);
        company.setCreatetime(createtime);
        company.setParentid(parentid);

        System.out.println(company);
        try{
            companyMapper.addCompany(company);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40001);
            return resp;
        }

        resp.setCode(200);
        resp.setData(company);
        return resp;
    }

    //修改企业信息
    @RequestMapping(value = "/updateCompany",method = RequestMethod.POST)
    public ResponseEntity<Company> updateCompany(@RequestParam(value = "companyid",required = false,defaultValue = "")String companyid,
                                                    @RequestParam(value = "companyname",required = false,defaultValue = "")String companyname,
                                                    @RequestParam(value = "address",required = false,defaultValue = "")String address,
                                                    @RequestParam(value = "abbreviation",required = false,defaultValue = "")String abbreviation,
                                                    @RequestParam(value = "certificate",required = false,defaultValue = "")String certificate,
                                                    @RequestParam(value = "createtime",required = false,defaultValue = "")String createtime,
                                                    @RequestParam(value = "parentid",required = false,defaultValue = "")String parentid){
        ResponseEntity<Company> resp = new ResponseEntity<>();
        Company company = new Company();
        Company oringin;
        try {
            oringin = companyMapper.selectCompanyById(companyid);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(30001);
            return resp;
        }
        if(StringUtils.isEmpty(companyid)){
            company.setCompanyid(oringin.getCompanyid());
        }
        if(StringUtils.isEmpty(companyname)){
            company.setCompanyname(oringin.getCompanyname());
        }
        if(StringUtils.isEmpty(address)){
            company.setAddress(oringin.getAddress());
        }
        if(StringUtils.isEmpty(abbreviation)){
            company.setAbbreviation(oringin.getAbbreviation());
        }
        if(StringUtils.isEmpty(certificate)){
           company.setCertificate(oringin.getCertificate());
        }
        if(StringUtils.isEmpty(createtime)){
           company.setCreatetime(oringin.getCreatetime());
        }
        company.setAbbreviation(abbreviation);
        company.setAddress(address);
        company.setCertificate(certificate);
        company.setCompanyid(companyid);
        company.setCompanyname(companyname);
        company.setCreatetime(createtime);
        company.setParentid(parentid);
        try {
            companyMapper.updateCompany(company);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40002);
            return resp;
        }

        resp.setCode(200);
        resp.setData(companyMapper.selectCompanyById(companyid));
        return resp;
    }

    //删除企业信息
    @RequestMapping(value = "/removeCompany",method = RequestMethod.POST)
    public ResponseEntity<Company> removeCompany(@RequestParam(value = "id",required = true,defaultValue = "")String id){
        ResponseEntity<Company> resp = new ResponseEntity();
        try {
            companyMapper.deleteCompany(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40003);
            return resp;
        }
        resp.setCode(200);
        return resp;

    }

    @RequestMapping(value = "/selectCompanyByName",method = RequestMethod.POST)
    public ResponseEntity<Company> selectCompanyByName(@RequestParam(value = "name",required = true,defaultValue = "")String name){
        ResponseEntity<Company> resp = new ResponseEntity();
        try {
            resp.setData(companyMapper.selectCompanyByName(name));
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40003);
            return resp;
        }
        resp.setCode(200);
        return resp;
    }

    @RequestMapping(value = "/selectCompanyById",method = RequestMethod.POST)
    public ResponseEntity<Company> selectCompanyById(@RequestParam(value = "id",required = true,defaultValue = "")String id){
        ResponseEntity<Company> resp = new ResponseEntity();
        try {
            resp.setData(companyMapper.selectCompanyById(id));
        }catch (Exception e){
            System.out.println(e.getMessage());
            resp.setCode(40003);
            return resp;
        }
        resp.setCode(200);
        return resp;
    }
}
