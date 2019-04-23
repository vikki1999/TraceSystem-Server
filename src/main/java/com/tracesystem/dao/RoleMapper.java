package com.tracesystem.dao;

import com.tracesystem.bean.Role;
import com.tracesystem.provider.RoleSqlProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface RoleMapper {

    @Select("select a.*,b.v as department from roles a ,dict b where b.type='department' and a.departmentid = b.k ")
    public List<Role> queryRoleList();

    @Select("select a.*,b.v as department from roles a ,dict b where b.type='department' and a.departmentid = b.k and roleid=#{roleid}")
    public Role selectRoleById(String roleid);
}
