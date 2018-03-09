package com.mapper;

import static com.mapper.UserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.domain.User;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<User> insertStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserResult")
    User selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="login_name", property="loginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.CHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="location_area", property="locationArea", jdbcType=JdbcType.VARCHAR),
        @Result(column="location_city", property="locationCity", jdbcType=JdbcType.VARCHAR),
        @Result(column="location_province", property="locationProvince", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(user);
    }

    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, user);
    }

    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, user)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    default int insert(User record) {
        return insert(SqlBuilder.insert(record)
                .into(user)
                .map(id).toProperty("id")
                .map(loginName).toProperty("loginName")
                .map(password).toProperty("password")
                .map(username).toProperty("username")
                .map(isDeleted).toProperty("isDeleted")
                .map(email).toProperty("email")
                .map(mobile).toProperty("mobile")
                .map(gmtCreate).toProperty("gmtCreate")
                .map(gmtModified).toProperty("gmtModified")
                .map(locationArea).toProperty("locationArea")
                .map(locationCity).toProperty("locationCity")
                .map(locationProvince).toProperty("locationProvince")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    default int insertSelective(User record) {
        return insert(SqlBuilder.insert(record)
                .into(user)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(loginName).toPropertyWhenPresent("loginName", record::getLoginName)
                .map(password).toPropertyWhenPresent("password", record::getPassword)
                .map(username).toPropertyWhenPresent("username", record::getUsername)
                .map(isDeleted).toPropertyWhenPresent("isDeleted", record::getIsDeleted)
                .map(email).toPropertyWhenPresent("email", record::getEmail)
                .map(mobile).toPropertyWhenPresent("mobile", record::getMobile)
                .map(gmtCreate).toPropertyWhenPresent("gmtCreate", record::getGmtCreate)
                .map(gmtModified).toPropertyWhenPresent("gmtModified", record::getGmtModified)
                .map(locationArea).toPropertyWhenPresent("locationArea", record::getLocationArea)
                .map(locationCity).toPropertyWhenPresent("locationCity", record::getLocationCity)
                .map(locationProvince).toPropertyWhenPresent("locationProvince", record::getLocationProvince)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<User>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, loginName, password, username, isDeleted, email, mobile, gmtCreate, gmtModified, locationArea, locationCity, locationProvince)
                .from(user);
    }

    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<User>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, loginName, password, username, isDeleted, email, mobile, gmtCreate, gmtModified, locationArea, locationCity, locationProvince)
                .from(user);
    }

    default User selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, loginName, password, username, isDeleted, email, mobile, gmtCreate, gmtModified, locationArea, locationCity, locationProvince)
                .from(user)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(User record) {
        return UpdateDSL.updateWithMapper(this::update, user)
                .set(id).equalTo(record::getId)
                .set(loginName).equalTo(record::getLoginName)
                .set(password).equalTo(record::getPassword)
                .set(username).equalTo(record::getUsername)
                .set(isDeleted).equalTo(record::getIsDeleted)
                .set(email).equalTo(record::getEmail)
                .set(mobile).equalTo(record::getMobile)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModified).equalTo(record::getGmtModified)
                .set(locationArea).equalTo(record::getLocationArea)
                .set(locationCity).equalTo(record::getLocationCity)
                .set(locationProvince).equalTo(record::getLocationProvince);
    }

    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(User record) {
        return UpdateDSL.updateWithMapper(this::update, user)
                .set(id).equalToWhenPresent(record::getId)
                .set(loginName).equalToWhenPresent(record::getLoginName)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(isDeleted).equalToWhenPresent(record::getIsDeleted)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(mobile).equalToWhenPresent(record::getMobile)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModified).equalToWhenPresent(record::getGmtModified)
                .set(locationArea).equalToWhenPresent(record::getLocationArea)
                .set(locationCity).equalToWhenPresent(record::getLocationCity)
                .set(locationProvince).equalToWhenPresent(record::getLocationProvince);
    }

    default int updateByPrimaryKey(User record) {
        return UpdateDSL.updateWithMapper(this::update, user)
                .set(loginName).equalTo(record::getLoginName)
                .set(password).equalTo(record::getPassword)
                .set(username).equalTo(record::getUsername)
                .set(isDeleted).equalTo(record::getIsDeleted)
                .set(email).equalTo(record::getEmail)
                .set(mobile).equalTo(record::getMobile)
                .set(gmtCreate).equalTo(record::getGmtCreate)
                .set(gmtModified).equalTo(record::getGmtModified)
                .set(locationArea).equalTo(record::getLocationArea)
                .set(locationCity).equalTo(record::getLocationCity)
                .set(locationProvince).equalTo(record::getLocationProvince)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    default int updateByPrimaryKeySelective(User record) {
        return UpdateDSL.updateWithMapper(this::update, user)
                .set(loginName).equalToWhenPresent(record::getLoginName)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(isDeleted).equalToWhenPresent(record::getIsDeleted)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(mobile).equalToWhenPresent(record::getMobile)
                .set(gmtCreate).equalToWhenPresent(record::getGmtCreate)
                .set(gmtModified).equalToWhenPresent(record::getGmtModified)
                .set(locationArea).equalToWhenPresent(record::getLocationArea)
                .set(locationCity).equalToWhenPresent(record::getLocationCity)
                .set(locationProvince).equalToWhenPresent(record::getLocationProvince)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}