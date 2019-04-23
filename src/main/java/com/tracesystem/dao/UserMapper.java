package com.tracesystem.dao;


import com.tracesystem.bean.Menu;
import com.tracesystem.bean.User;
import com.tracesystem.provider.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by 刘佳 on 2019/2/12
 */
@Mapper
public interface UserMapper {

    //用户登陆
    @Select("select a.*,b.rolename,b.power,c.moudelid,d.path as indexpage from users a,roles b ,companies c,menus d " +
            "where a.roleid=b.roleid and a.companyid=c.companyid and username=#{username} and loginpwd=#{password}" +
            " and c.moudelid=d.moudelid and b.power=d.power order by d.number desc limit 1")
    public User login(String username,String password);

    //地区
    @Select("select distinct local from users")
    public List<String> getLocal();
    //找到首页
    @Select("select * from menus where moudelid=#{moudelid} and number=1")
    public Menu getIndex(String moudelid);

    //查询用户
    @SelectProvider(type = UserSqlProvider.class, method = "selectWithParam")
    List<User> search(Map<String, Object> params);

    @Select("select a.*,b.rolename from users a,roles b where a.roleid=b.roleid and a.roleid = '10711' and companyid=#{companyid}")
    public List<User> selectDesigner(String companyid);

    @Select("select a.*,b.rolename,b.power,c.moudelid,d.path as indexpage from users a,roles b ,companies c,menus d " +
            " where a.roleid=b.roleid and a.companyid=c.companyid and a.userid = #{id}" +
            " and c.moudelid=d.moudelid and b.power=d.power order by d.number desc limit 1 ")
    public User selectUserById(int id);

    @Select("select a.*,b.rolename from users a,roles b where a.roleid=b.roleid and username like CONCAT('%', #{name}, '%')")
    public List<User> selectUserByName(String name);

    @Select("select a.*,b.rolename from users a,roles b where a.roleid=b.roleid and a.companyid=#{companyid}")
    public List<User> findAll(String companyid);

    @Insert("insert into users" +
            "(UserName,loginpwd,mobilephone,email,permissions,local,gender,createtime,roleid,companyid)" +
            " values(#{username},#{loginpwd},#{mobilephone}," +
            "#{email},#{permissions},#{local},#{gender},#{createtime},#{roleid},#{companyid})")
    public void addUser(User user);

    @Delete("delete from users where userid=#{id}")
    public void deleteUser(int id);

    @Update("update users set " +
            "username=#{username},loginpwd=#{loginpwd},mobilephone=#{mobilephone},email=#{email}," +
            "permissions=#{permissions},local=#{local}" +
            ",gender=#{gender},createtime=#{createtime},roleid=#{roleid},companyid=#{companyid} where userid=#{userid} ")
    public void updateUser(User user);

    //设置管理员
    @Update("update users set roleid='10000' where userid = #{userid}")
    public void setAdmin(int userid);
}
