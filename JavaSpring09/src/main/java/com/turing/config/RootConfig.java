package com.turing.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 全局配置项 扫描项目的所有包，但是需要把SpringMVC已经扫描过的例外掉
 * 
 * @author fred
 *
 */

@Configuration
@ComponentScan(basePackages = "com.turing",excludeFilters = {
		@Filter(type = FilterType.ANNOTATION, value = { EnableWebMvc.class, Controller.class }) })
@MapperScan(basePackages = "com.turing.mapper") // 扫描Mapper所在包
@ImportResource("classpath:spring-transaction.xml") // 导入事务的配置文件
public class RootConfig {

		// 配置数据源
		// 加入数据源
		@Bean
		public DataSource dataSource() {
			BasicDataSource dataSource = new BasicDataSource();
			// 连接四要素
			dataSource.setUrl("jdbc:mysql:///staff");
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUsername("root");
			dataSource.setPassword("123456");
			// 连接池的一些属性
			dataSource.setInitialSize(20);// 初始连接数
			dataSource.setMaxIdle(10);// 最大闲置数
			dataSource.setMinIdle(2);// 最小闲置数
			dataSource.setMaxTotal(50);// 最大连接数
			dataSource.setMaxWaitMillis(5000);// 最大连接等待时间
			return dataSource;
		}
		
		@Bean
		public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			// 设置数据源
			factoryBean.setDataSource(dataSource);
			return factoryBean.getObject();
		}

		// 配置事务管理器
		@Bean
		public DataSourceTransactionManager transactionManager(DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}
	
}
