package com.tracesystem.dao;

import com.tracesystem.bean.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 刘佳 on 2019-03-21 21:26
 **/
@Mapper
public interface AdminMapper {

        //查询管理员

        @Select("select a.*,b.username,b.gender,b.mobilephone,b.email,b.local from admins a" +
                " join users b on a.userid=b.userid where b.companyid=#{companyid}")
        public List<Admin> selectAdmin(String companyid);

        @Select("select a.*,b.username,b.gender,b.mobilephone,b.email,b.local from admins a" +
                " join users b on a.userid=b.userid where a.adminid = #{id}")
        public Admin selectAdminById(int id);

        //增加管理员:逻辑上只能从用户中设置
        @Insert("insert into admins(userid,ethaccount,ethpwd) values(#{userid},#{ethaccount},#{ethpwd})")
        public void insertAdmin(Admin admin);

        //删除管理员
        @Delete("delete from admins where adminid=#{id}")
        public void deleteAdmin(int id);

        //更新管理员权限、部门、区块链账号密码
        @Update("update admins set " +
                "ethaccount=#{ethaccount},ethpwd=#{ethpwd} " +
                " where adminid=#{adminid} ")
        public void updateAdmin(Admin admin);



}
