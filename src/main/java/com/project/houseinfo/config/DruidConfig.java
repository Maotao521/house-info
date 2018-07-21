package com.project.houseinfo.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Created By 胡玉国 on 2018/7/16
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix ="spring.druid")
    @Bean(initMethod ="init",destroyMethod = "close")
    public DruidDataSource dataSource(){
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return dataSource;
    }

    /**
     * 将执行比较慢的SQL打印出来供用户查看
     * @return
     */
    @Bean
    public Filter statFilter(){
        StatFilter statFilter=new StatFilter();
        //指定当大于5000毫秒时属于慢SQL
        statFilter.setSlowSqlMillis(5000);
        statFilter.setLogSlowSql(true);
        statFilter.setMergeSql(true);
        return statFilter;
    }

    /**
     * 开启监控功能检查慢SQL
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        return new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
    }
}
