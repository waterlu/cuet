package cn.lu.cuet.data.loader.mybatis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by lu on 16-10-9.
 */
public class JsonTypeHandler<T extends Object> extends BaseTypeHandler<T> {

    private Class<T> clazz;

    public JsonTypeHandler(Class<T> clazz) {
        if (clazz == null) throw new IllegalArgumentException("Type argument cannot be null");
        this.clazz = clazz;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, T parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, JSON.toJSONString(parameter, SerializerFeature.PrettyFormat));
    }

    @Override
    public T getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return JSON.parseObject(resultSet.getString(columnName), clazz);
    }

    @Override
    public T getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return JSON.parseObject(resultSet.getString(columnIndex), clazz);
    }

    @Override
    public T getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return JSON.parseObject(callableStatement.getString(columnIndex), clazz);
    }
}
