package cn.amos.frame.mybatis.config;

import cn.amos.frame.mybatis.plugin.MyPlugin;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * DESCRIPTION: MyBatisConfig
 *
 * @author <a href="mailto:amos.wang@xiaoi.com">amos.wang</a>
 * @date 3/5/2020
 */
@Configuration
@ComponentScan("cn.amos.frame.mybatis")
@MapperScan("cn.amos.frame.mybatis.dao")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource());
        bean.setPlugins(getMyPlugin());
        return bean.getObject();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/mall");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    public Interceptor getMyPlugin() {
        return new MyPlugin().setEndFlag(".*ByPage$");
    }

}
