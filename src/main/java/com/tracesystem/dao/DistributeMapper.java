package com.tracesystem.dao;

import com.tracesystem.bean.Distribute;
import com.tracesystem.bean.User;
import com.tracesystem.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DistributeMapper {

    @Select("select * from distributes where distributeid = #{id}")
    public Distribute selectDistributeById(String id);

    @Select("select * from distributes where distributename like CONCAT('%', #{name}, '%')")
    public List<Distribute> selectDistributeByName(String name);

    @Select("select * from distributes where companyid=#{companyid}")
    public List<Distribute> findAll(String companyid);

    @Insert("insert into distributes" +
            "(distributeid,distributename,address,companyid,createdate)" +
            " values(#{distributeid},#{distributename},#{address}," +
            "#{companyid},#{createdate})")
    public void addDistribute(Distribute distribute);

    @Delete("delete from distributes where distributeid=#{id}")
    public void deleteDistribute(String id);

    @Update("update distributes set " +
            "distributename=#{distributename},address=#{address},companyid=#{companyid}" +
            " ,createdate=#{createdate} where distributeid=#{distributeid} ")
    public void updateDistribute(Distribute distribute);
}
