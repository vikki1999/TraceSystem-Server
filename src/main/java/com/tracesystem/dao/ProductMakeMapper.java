package com.tracesystem.dao;

import com.tracesystem.bean.ProductMake;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMakeMapper {


    @Select("select c.productmakeid,c.productmakeitemid,c.time,c.`status`,d.productid,d.productmakename,d.step,g.companyname,e.technologyname,e.technologyname,f.ProductName as rawname,h.productname from productmakeitem c,productmakes d,technologies e,products f,companies g,products h " +
            "where d.technologyid=e.technologyid and c.productmakeid=d.id and d.rawid=f.ProductID and d.companyid=g.companyid and d.productid=h.productid" +
            " and c.traceid IN" +
            " (select b.traceid from productpre b where traceid = #{traceid}" +
            "  union all" +
            " select a.traceid from productpre a join productpre b on a.traceid=b.previousid) order by c.time")
    public List<ProductMake> findAll(String traceid);

    @Select("select a.productid,a.productname,b.productmakeid,b.designdate from products a ,productmakes b " +
            "where a.productid=b.productid and b.productmakeid in " +
            "(select distinct productmakeid from productmakes where companyid=#{companyid})")
    public List<ProductMake> queryProductMakeList(String companyid);
    @Select("select a.step,a.id,a.productmakeid,a.productid,a.productmakename,b.productname,c.technologyname,d.productname as rawname from productmakes a ,products b,technologies c,products d" +
            " where a.productid = b.productid and a.technologyid=c.technologyid and a.rawid = d.productid and a.productmakeid=#{productmakeid}")
    public List<ProductMake> querySingleProductMake(String productmakeid);
}
