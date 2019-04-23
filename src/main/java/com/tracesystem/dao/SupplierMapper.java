package com.tracesystem.dao;

import com.tracesystem.bean.Supplier;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SupplierMapper {
    @Select("select * from suppliers")
    public List<Supplier> getAllSuppliers();

    @Select("select * from suppliers where companyid=#{companyid}")
    public List<Supplier> getSuppliers(String companyid);


}
