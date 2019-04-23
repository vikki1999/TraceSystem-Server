package com.tracesystem.dao;

import com.tracesystem.bean.Brand;
import com.tracesystem.bean.User;
import com.tracesystem.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface BrandMapper {
//    //查询品牌
//    @SelectProvider(type = UserSqlProvider.class, method = "selectWithParam")
//    List<User> search(Map<String, Object> params);

    @Select("select a.brandid,a.brandname,a.history,a.createtime,a.category,a.src,b.companyname from brands a" +
            " join companies b on a.companyid=b.companyid where brandid = #{id}")
    public Brand selectBrandById(String id);

    @Select("select companyid from companies where companyname = #{name}")
    public String getCompanyId(String name);

    @Select("select a.brandid,a.brandname,a.history,a.createtime,a.category,a.src,b.companyname from brands a" +
            " join companies b on a.companyid=b.companyid where a.brandname like CONCAT('%', #{name}, '%')")
    public List<Brand> selectBrandByName(String name);

    @Select("select a.brandid,a.brandname,a.history,a.createtime,a.category,a.src,b.companyname from brands a" +
            " join companies b on a.companyid=b.companyid")
    public List<Brand> findAll();

    @Insert("insert into brands" +
            "(brandid,brandname,history,category,companyid,createtime,src)" +
            " values(#{brandid},#{brandname},#{history}," +
            "#{category},#{companyid},#{createtime},#{src})")
    public void addBrand(Brand brand);

    @Delete("delete from brands where brandid=#{id}")
    public void deleteBrand(String id);

    @Update("update brands set " +
            "brandid=#{brandid},brandname=#{brandname},history=#{history},category=#{category}," +
            "companyid=#{companyid},createtime=#{createtime},src=#{src} where brandid=#{brandid} ")
    public void updateBrand(Brand brand);
}
