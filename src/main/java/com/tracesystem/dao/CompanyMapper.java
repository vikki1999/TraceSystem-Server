package com.tracesystem.dao;

import com.tracesystem.bean.Company;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 刘佳 on 2019-03-21 21:26
 **/
@Mapper
public interface CompanyMapper {
    @Select("select * from companies where companyid = #{id}")
    public Company selectCompanyById(String id);

    @Select("select * from companies where companyname=#{name}")
    public Company selectCompanyByName(String name);

    @Select("select * from companies")
    public List<Company> findAll();

    @Insert("insert into companies" +
            "(companyid,companyname,abbreviation,certificate,address,createtime,parentid)" +
            " values(#{companyid},#{companyname},#{abbreviation},#{certificate},#{createtime},#{parentid})")
    public void addCompany(Company company);

    @Delete("delete from companies where companyid=#{id}")
    public void deleteCompany(String id);

    @Update("update companies set " +
            "companyid=#{companyid},companyname=#{companyname},address=#{address},abbreviation=#{abbreviation},certificate=#{certificate}" +
            "createtime=#{createtime},parentid=#{parentid} where companyid=#{companyid} ")
    public void updateCompany(Company company);

}
