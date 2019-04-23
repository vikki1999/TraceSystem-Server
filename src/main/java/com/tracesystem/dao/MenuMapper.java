package com.tracesystem.dao;

import com.tracesystem.bean.Menu;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by 刘佳 on 2019-03-27 10:24
 **/
@Mapper
public interface MenuMapper {

    @Results({
            @Result(property = "key",column = "key"),
            @Result(property = "path",column = "path"),
            @Result(property = "parentkey",column = "parentkey"),
            @Result(property = "children",column = "{key=key,moudelid=moudelid}",javaType = List.class,many=@Many(select = "com.tracesystem.dao.MenuMapper.findChildrenMenu"))
    })
    @Select("select * from menus where number=0 and moudelid=#{moudelid}")
    public List<Menu> findMenu(String moudelid);

    @Select("select * from menus where parentkey=#{key} and moudelid=#{moudelid}")
    public List<Menu> findChildrenMenu(String key,String moudelid);
}
