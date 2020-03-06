package cn.amos.frame.mybatis.plugin;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * DESCRIPTION: MyPlugin
 * 不同拦截器执行顺序
 * Executor -> ParameterHandler -> StatementHandler -> ResultSetHandler
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
@Intercepts(
        @Signature(type = StatementHandler.class,
                method = "prepare", args = {Connection.class, Integer.class}))
@Component
public class MyPlugin implements Interceptor {

    private String endFlag;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler handler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(handler,
                SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
                new DefaultReflectorFactory());
        String value = (String) metaObject.getValue("delegate.mappedStatement.id");
        if (value.matches(getEndFlag())) {
            BoundSql boundSql = handler.getBoundSql();
            String sql = boundSql.getSql();
            System.out.printf("原始 SQL [%s]\n", sql);
            String countSql = "select count(0) from (" + sql + ") temp";
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement preparedStatement = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            PageModule pageModule = (PageModule) parameterHandler.getParameterObject();
            parameterHandler.setParameters(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                pageModule.setCount(resultSet.getInt(1));
            }
            resultSet.close();
            preparedStatement.close();

            sql = String.format(sql + " limit %d, %d", pageModule.getStart(), pageModule.getSize());
            metaObject.setValue("delegate.boundSql.sql", sql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    /**
     * 为什么有这个呢？ MyBatis是个独立的框架
     */
    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));
    }

    public String getEndFlag() {
        return endFlag;
    }

    public MyPlugin setEndFlag(String endFlag) {
        this.endFlag = endFlag;
        return this;
    }
}
