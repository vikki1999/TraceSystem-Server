package com.tracesystem.provider;

import org.apache.ibatis.jdbc.SQL;
import org.apache.commons.lang.StringUtils;

import java.util.Map;

/**
 * Created by 刘佳 on 2019-03-12 10:17
 **/
public class UserSqlProvider {
    public String selectWithParam(final Map<String, Object> param) {
        String sql = new SQL() {
            {
                SELECT("*");
                FROM("users b");
                if (param.containsKey("id") && StringUtils.isNotEmpty(param.get("id").toString())) {
                    WHERE("b.userid = " + param.get("id").toString());
                }


                if (param.containsKey("keyword") && StringUtils.isNotEmpty(param.get("keyword").toString())) {
                    WHERE("(b.username like CONCAT('%', #{keyword}, '%') OR b.local like CONCAT('%', #{keyword}, '%') ) ");
                }
            }
        }.toString();
        return sql;
    }
}
