package com.mapper;

import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserDynamicSqlSupport {
    public static final User user = new User();

    public static final SqlColumn<Long> id = user.id;

    public static final SqlColumn<String> loginName = user.loginName;

    public static final SqlColumn<String> password = user.password;

    public static final SqlColumn<String> username = user.username;

    public static final SqlColumn<String> isDeleted = user.isDeleted;

    public static final SqlColumn<String> email = user.email;

    public static final SqlColumn<String> mobile = user.mobile;

    public static final SqlColumn<Date> gmtCreate = user.gmtCreate;

    public static final SqlColumn<Date> gmtModified = user.gmtModified;

    public static final SqlColumn<String> locationArea = user.locationArea;

    public static final SqlColumn<String> locationCity = user.locationCity;

    public static final SqlColumn<String> locationProvince = user.locationProvince;

    public static final class User extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> loginName = column("login_name", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<String> isDeleted = column("is_deleted", JDBCType.CHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> mobile = column("mobile", JDBCType.VARCHAR);

        public final SqlColumn<Date> gmtCreate = column("gmt_create", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> gmtModified = column("gmt_modified", JDBCType.TIMESTAMP);

        public final SqlColumn<String> locationArea = column("location_area", JDBCType.VARCHAR);

        public final SqlColumn<String> locationCity = column("location_city", JDBCType.VARCHAR);

        public final SqlColumn<String> locationProvince = column("location_province", JDBCType.VARCHAR);

        public User() {
            super("user");
        }
    }
}