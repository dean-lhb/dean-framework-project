package org.deanframework.component.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.deanframework.component.datasource.exception.DataSourceException;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @auther Dean
 */
public class DataSourceHelper {

    /**
     * 创建数据源
     * @return
     */
    public static DataSource createDataSource() {
        return new DruidDataSource();
    }

    /**
     * 创建事务管理器
     * @param dataSource
     * @return
     */
    public static DataSourceTransactionManager createDataSourceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 创建数据库连接工厂
     * @param dataSource
     * @param mapperLocationPattern
     * @return
     */
    public static SqlSessionFactory createSqlSessionFactory(DataSource dataSource, String mapperLocationPattern) {
        try {
            SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
            sf.setDataSource(dataSource);
            sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocationPattern));
            //设置默认属性
            Configuration configuration = new Configuration();
            configuration.setCallSettersOnNulls(true);
            //设置驼峰标识转换
            configuration.setMapUnderscoreToCamelCase(true);
            sf.setConfiguration(configuration);
            return sf.getObject();
        } catch (Exception e) {
            throw new DataSourceException(e);
        }
    }
}
