package com.tracesystem.dao;

import com.tracesystem.bean.Technology;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TechnologyMapper  {
    @Select("select * from technologies where technologyid = #{id}")
    public Technology selectTechnologyById(int id);

    @Select("select * from technologies where technologyname=#{name}")
    public List<Technology> selectTechnologyByName(String name);

    @Select("select * from technologies where companyid=#{companyid}")
    public List<Technology> findAll(String companyid);

    @Insert("insert into technologies" +
            "(technologyname,note,patenid,patentcategory,companyid)" +
            " values(#{technologyname},#{note},#{patentid},#{patentcategory},#{companyid})")
    public void addTechnology(Technology technology);

    @Delete("delete from technologies where technologyid=#{id}")
    public void deleteTechnology(int id);

    @Update("update technologies set " +
            "technologyname=#{technologyname},note=#{note},patentid=#{patentid},patentcategory=#{patentcategory}" +
            " ,companyid=#{companyid} where technologyid=#{technologyid} ")
    public void updateTechnology(Technology technology);
}
