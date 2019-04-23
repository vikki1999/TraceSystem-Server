package com.tracesystem.provider;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * Created by 刘佳 on 2019-04-07 11:07
 **/
public class RoleSqlProvider {
    public String selectWithParam(final Map<String, Object> param) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("roles b");
                if (param.containsKey("roleid") && StringUtils.isNotEmpty(param.get("roleid").toString())) {
                    WHERE("b.roleid = " + param.get("roleid").toString());
                }


                if (param.containsKey("keyword") && StringUtils.isNotEmpty(param.get("keyword").toString())) {
                    WHERE("(b.rolename like CONCAT('%', #{keyword}, '%')  ) ");
                }
            }
        }.toString();
        return sql;
    }
}
